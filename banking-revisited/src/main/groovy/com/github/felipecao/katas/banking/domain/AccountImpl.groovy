package com.github.felipecao.katas.banking.domain

import com.github.felipecao.katas.banking.support.Amount

import java.time.Clock

class AccountImpl implements Account {

    private final Clock clock
    private final Transactions transactions = new Transactions()
    private Amount balance = Amount.of(0)

    AccountImpl() {
        this(Clock.systemDefaultZone())
    }

    protected AccountImpl(final Clock clock) {
        this.clock = clock
    }

    Amount getBalance() {
        balance
    }

    void deposit(Amount amount) {
        balance = balance.plus(amount)
        transactions.add(new Deposit(this, clock.instant(), amount, balance))
    }

    void withdraw(Amount amount) {
        balance = balance.minus(amount)
        transactions.add(new Withdrawal(this, clock.instant(), amount, balance))
    }

    boolean totalTransactionsIs(int totalTransactions) {
        return transactions.total == totalTransactions
    }

    @Override
    boolean containsTransaction(Transaction transaction) {
        return transactions.contains(transaction)
    }

    @Override
    void forEachTransaction(Closure c) {
        transactions.forEach(c)
    }
}
