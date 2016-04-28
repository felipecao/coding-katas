package br.felipecao.kata.core.domain;

import br.felipecao.kata.core.support.Amount;

import java.util.SortedSet;

class AccountImpl implements Account {

    private Transactions transactions = new Transactions();
    private Amount balance = Amount.ZERO;

    @Override
    public Amount getBalance() {
        return balance;
    }

    @Override
    public void deposit(Amount amount) {
        balance = balance.plus(amount);
    }

    @Override
    public void withdraw(Amount amount) {
        balance = balance.minus(amount);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    @Override
    public SortedSet<Transaction> getTransactions() {
        return transactions.getAll();
    }
}
