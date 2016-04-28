package br.felipecao.kata.core.domain;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by felipe on 4/28/16.
 */
public class Transactions {
    private SortedSet<Transaction> transactions;

    public Transactions() {
        transactions = new TreeSet<>();
    }

    public void add(Transaction t) {
        transactions.add(t);
    }

    public SortedSet<Transaction> getAll() {
        return transactions;
    }
}
