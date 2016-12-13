package com.github.felipecao.katas.banking.acceptance

import com.github.felipecao.katas.banking.domain.Account
import com.github.felipecao.katas.banking.domain.AccountImpl
import com.github.felipecao.katas.banking.domain.Deposit
import com.github.felipecao.katas.banking.domain.Withdrawal
import com.github.felipecao.katas.banking.support.Amount
import com.github.felipecao.katas.banking.support.RandomAmount
import spock.lang.Specification
import spock.lang.Unroll

import java.time.Clock
import java.time.Instant

@Unroll
class DepositAndWithdrawalAcceptanceTests extends Specification {

    private Account account
    private Clock clock
    private Instant currentInstant

    def setup() {
        clock = Mock()
        account = new AccountImpl(clock)

        currentInstant = Instant.now()
        clock.instant() >> currentInstant
    }

    def "a new account is created with balance zero"() {
        expect:
        Amount.of(0) == account.balance
    }

    def "a deposit of #amount increases the account balance by the same amount and adds deposit transaction to account"() {
        given:
        Amount initialAmount = account.balance

        when:
        account.deposit(amount)

        then:
        account.balance == initialAmount.plus(amount)

        and:
        account.totalTransactionsIs(1)
        account.containsTransaction(new Deposit(account, currentInstant, amount, amount))

        where:
        amount         | _
        RandomAmount.get() | _
    }

    def "a withdrawal of #amount decreases the account balance by the same amount and adds withdrawal transaction to account"() {
        given:
        def initialAmount = account.balance

        when:
        account.withdraw(amount)

        then:
        account.balance == initialAmount.minus(amount)

        and:
        account.totalTransactionsIs(1)
        account.containsTransaction(new Withdrawal(account, currentInstant, amount, amount))

        where:
        amount         | _
        RandomAmount.get() | _
    }

    def "two deposits increase the account balance by the sum of the amounts and add two deposit transactions to account"() {
        given:
        def initialAmount = account.balance
        def firstAmount = RandomAmount.get()
        def secondAmount = RandomAmount.get()

        when:
        account.deposit(firstAmount)
        account.deposit(secondAmount)

        then:
        account.balance == initialAmount.plus(firstAmount).plus(secondAmount)

        and:
        account.totalTransactionsIs(2)
        account.containsTransaction(new Deposit(account, currentInstant, firstAmount, initialAmount.plus(firstAmount)))
        account.containsTransaction(new Deposit(account, currentInstant, secondAmount, initialAmount.plus(firstAmount).plus(secondAmount)))
    }

    def "two withdrawals decrease the account balance by the sum of the amounts and add two withdrawal transactions to account"() {
        given:
        def initialAmount = account.balance
        def firstAmount = RandomAmount.get()
        def secondAmount = RandomAmount.get()

        when:
        account.withdraw(firstAmount)
        account.withdraw(secondAmount)

        then:
        account.balance == initialAmount.minus(firstAmount).minus(secondAmount)

        and:
        account.totalTransactionsIs(2)
        account.containsTransaction(new Withdrawal(account, currentInstant, firstAmount, initialAmount.minus(firstAmount)))
        account.containsTransaction(new Withdrawal(account, currentInstant, secondAmount, initialAmount.minus(firstAmount).minus(secondAmount)))
    }

    def "a deposit followed by a withdrawal results in two transactions"() {
        given:
        def initialAmount = account.balance
        def firstAmount = RandomAmount.get()
        def secondAmount = RandomAmount.get()

        when:
        account.deposit(firstAmount)
        account.withdraw(secondAmount)

        then:
        account.balance == initialAmount.plus(firstAmount).minus(secondAmount)

        and:
        account.totalTransactionsIs(2)
        account.containsTransaction(new Deposit(account, currentInstant, firstAmount, initialAmount.plus(firstAmount)))
        account.containsTransaction(new Withdrawal(account, currentInstant, secondAmount, initialAmount.plus(firstAmount).minus(secondAmount)))
    }

}
