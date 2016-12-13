package com.github.felipecao.katas.banking.domain

import com.github.felipecao.katas.banking.support.Amount

interface Account {

    Amount getBalance()

    void deposit(Amount amount)

    void withdraw(Amount amount)

    boolean totalTransactionsIs(int totalTransactions)

    boolean containsTransaction(Transaction transaction)

    void forEachTransaction(Closure c)

}