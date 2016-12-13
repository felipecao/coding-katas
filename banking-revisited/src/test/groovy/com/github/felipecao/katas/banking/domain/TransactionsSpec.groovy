package com.github.felipecao.katas.banking.domain

import com.github.felipecao.katas.banking.support.RandomAmount
import spock.lang.Specification

class TransactionsSpec extends Specification {

    private Transactions transactions

    def setup() {
        transactions = new Transactions()
    }

    def "when a transaction is added, total increases and the added transaction is present in the collection"() {
        given:
        Transaction txn = new Deposit(null, null, RandomAmount.get(), RandomAmount.get())

        and:
        0 == transactions.total

        when:
        transactions.add(txn)

        then:
        1 == transactions.total
        transactions.contains(txn)
    }

    def "when the collection has two transactions, forEach runs twice"() {
        given:
        transactions.add(new Deposit(null, null, RandomAmount.get(), RandomAmount.get()))
        transactions.add(new Withdrawal(null, null, RandomAmount.get(), RandomAmount.get()))

        and:
        PrintStream console = Mock()

        when:
        transactions.forEach {
            console.println()
        }

        then:
        2 * console.println()
    }

}
