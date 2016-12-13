package com.github.felipecao.katas.banking.domain

interface Transaction {

    void appendDateTo(StringBuilder str)
    void appendAmountTo(StringBuilder str)
    void appendBalanceAfterTransactionTo(StringBuilder str)

}