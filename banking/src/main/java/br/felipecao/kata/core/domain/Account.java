package br.felipecao.kata.core.domain;

import br.felipecao.kata.core.support.Amount;

import java.util.SortedSet;

public interface Account {

    Amount getBalance();

    void deposit(Amount amount);

    void withdraw(Amount amount);

    void addTransaction(Transaction transaction);

    SortedSet<Transaction> getTransactions();
}
