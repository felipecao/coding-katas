package com.github.felipecao.katas.banking.domain

import com.github.felipecao.katas.banking.support.Amount

import java.time.Instant

class Withdrawal extends AbstractTransaction {
    protected Withdrawal(Account account, Instant date, Amount amount, Amount balanceAfterTransaction) {
        super(account, date, Amount.negativeOf(amount), balanceAfterTransaction)
    }
}
