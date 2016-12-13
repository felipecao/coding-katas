package com.github.felipecao.katas.banking.domain

import com.github.felipecao.katas.banking.support.Amount

import java.time.Instant

interface Transaction {

    Instant getDate()
    Amount getAmount()
    Amount getBalanceAfterTransaction()

}