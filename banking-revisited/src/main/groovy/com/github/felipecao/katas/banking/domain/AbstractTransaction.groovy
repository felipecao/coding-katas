package com.github.felipecao.katas.banking.domain

import com.github.felipecao.katas.banking.support.Amount
import groovy.transform.EqualsAndHashCode

import java.time.Instant

@EqualsAndHashCode(includes = ["account", "operation"])
class AbstractTransaction implements Transaction {

    private Account account
    private Operation operation
    private Amount balanceAfterTransaction

    protected AbstractTransaction(Account account, Instant date, Amount amount, Amount balanceAfterTransaction) {
        this.account = account
        this.operation = new Operation(date, amount)
        this.balanceAfterTransaction = balanceAfterTransaction
    }

    @Override
    void appendDateTo(StringBuilder str) {
        operation.appendDateTo(str)
    }

    @Override
    void appendAmountTo(StringBuilder str) {
        operation.appendAmountTo(str)
    }

    @Override
    void appendBalanceAfterTransactionTo(StringBuilder str) {
        str.append(balanceAfterTransaction)
    }
}
