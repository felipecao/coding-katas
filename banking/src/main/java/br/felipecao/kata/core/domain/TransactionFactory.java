package br.felipecao.kata.core.domain;

import br.felipecao.kata.core.support.Amount;

import java.time.LocalDate;

public class TransactionFactory {
    public Transaction newTransaction(LocalDate date, Amount amount, TransactionType type) {
        if(null == date || null == amount || null == type) {
            throw new IllegalArgumentException();
        }
        return new TransactionImpl(date, amount, type);
    }
}
