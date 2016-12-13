package com.github.felipecao.katas.banking.acceptance

import com.github.felipecao.katas.banking.domain.Account
import com.github.felipecao.katas.banking.domain.AccountImpl
import com.github.felipecao.katas.banking.support.Amount
import com.github.felipecao.katas.banking.support.RandomAmount
import com.github.felipecao.katas.banking.useCase.PrintStatement
import spock.lang.Specification

import java.time.Clock
import java.time.Instant

class StatementPrintingAcceptanceTests extends Specification {

    private Clock clock

    private Instant instant

    private PrintStream console

    def setup() {
        clock = Mock()
        console = Mock()

        instant = Instant.now()
        clock.instant() >> instant
    }

    def "empty statement for account without transactions"() {
        given:
        Account account = accountWithoutTransactions()

        and:
        PrintStatement useCase = new PrintStatement(account, console)

        when:
        useCase.execute()

        then:
        1 * console.println(statementWithHeadersOnly())
    }

    def "statement with one deposit entry"() {
        given:
        Amount amount = RandomAmount.get()

        and:
        Account account = accountWithOneDeposit(clock, amount)

        and:
        PrintStatement useCase = new PrintStatement(account, console)

        when:
        useCase.execute()

        then:
        1 * console.println(statementWithHeadersOnly())
        1 * console.println(statementRow(instant, amount, amount))
    }

    def "statement with one withdraw entry"() {
        given:
        Amount amount = RandomAmount.get()

        and:
        Account account = accountWithOneWithdraw(clock, amount)

        and:
        PrintStatement useCase = new PrintStatement(account, console)

        when:
        useCase.execute()

        then:
        1 * console.println(statementWithHeadersOnly())
        1 * console.println(statementRow(instant, Amount.negativeOf(amount), Amount.negativeOf(amount)))
    }

    def "statement with one deposit and one withdraw"() {
        given:
        Amount firstAmount = RandomAmount.get()
        Amount secondAmount = RandomAmount.get()

        and:
        Account account = accountWithOneDepositAndOneWithdraw(clock, firstAmount, secondAmount)

        and:
        PrintStatement useCase = new PrintStatement(account, console)

        when:
        useCase.execute()

        then:
        1 * console.println(statementWithHeadersOnly())
        1 * console.println(statementRow(instant, firstAmount, firstAmount))
        1 * console.println(statementRow(instant, Amount.negativeOf(secondAmount), firstAmount.minus(secondAmount)))
    }

    private AccountImpl accountWithoutTransactions() {
        new AccountImpl()
    }

    private AccountImpl accountWithOneDeposit(Clock clock, Amount amount) {
        Account account = new AccountImpl(clock)

        account.deposit(amount)

        return account
    }

    private AccountImpl accountWithOneWithdraw(Clock clock, Amount amount) {
        Account account = new AccountImpl(clock)

        account.withdraw(amount)

        return account
    }

    private AccountImpl accountWithOneDepositAndOneWithdraw(Clock clock, Amount... amounts) {
        Account account = new AccountImpl(clock)

        account.deposit(amounts[0])
        account.withdraw(amounts[1])

        return account
    }

    String statementWithHeadersOnly() {
        return PrintStatement.HEADER
    }

    String statementRow(Instant instant, Amount amount, Amount balanceAfterTransaction) {
        return "${instant} | ${amount} | ${balanceAfterTransaction}".toString()
    }

}
