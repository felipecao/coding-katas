package com.github.felipecao.katas.banking.domain

import com.github.felipecao.katas.banking.support.Amount
import groovy.transform.EqualsAndHashCode

import java.time.Instant

@EqualsAndHashCode
class Operation {

    private Instant date
    private Amount amount

    Operation(Instant date, Amount amount) {
        this.date = date
        this.amount = amount
    }

    void appendDateTo(StringBuilder str) {
        str.append(date)
    }

    void appendAmountTo(StringBuilder str) {
        str.append(amount)
    }
}
