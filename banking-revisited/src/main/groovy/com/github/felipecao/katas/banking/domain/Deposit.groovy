package com.github.felipecao.katas.banking.domain

import com.github.felipecao.katas.banking.support.Amount

import java.time.Instant

class Deposit extends AbstractTransaction {
    protected Deposit(Account account, Instant date, Amount amount, Amount balanceAfterTransaction) {
        super(account, date, amount, balanceAfterTransaction)
    }
}
