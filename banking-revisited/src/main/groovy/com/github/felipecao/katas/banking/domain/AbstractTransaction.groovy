package com.github.felipecao.katas.banking.domain

import com.github.felipecao.katas.banking.support.Amount

import java.time.Instant

class AbstractTransaction implements Transaction {

    private Account account
    private Instant date
    private Amount amount
    private Amount balanceAfterTransaction

    protected AbstractTransaction(Account account, Instant date, Amount amount, Amount balanceAfterTransaction) {
        this.account = account
        this.date = date
        this.amount = amount
        this.balanceAfterTransaction = balanceAfterTransaction
    }

    @Override
    Instant getDate() {
        return date
    }

    @Override
    Amount getAmount() {
        return amount
    }

    @Override
    Amount getBalanceAfterTransaction() {
        return balanceAfterTransaction
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        AbstractTransaction that = (AbstractTransaction) o

        if (account != that.account) return false
        if (amount != that.amount) return false
        if (date != that.date) return false

        return true
    }

    int hashCode() {
        int result
        result = (account != null ? account.hashCode() : 0)
        result = 31 * result + (date != null ? date.hashCode() : 0)
        result = 31 * result + (amount != null ? amount.hashCode() : 0)
        return result
    }
}
