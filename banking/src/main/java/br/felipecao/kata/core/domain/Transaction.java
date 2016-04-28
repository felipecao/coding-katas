package br.felipecao.kata.core.domain;

import br.felipecao.kata.core.support.Amount;

import java.time.LocalDate;

public interface Transaction {
    Amount getAmount();
    LocalDate getDate();
    TransactionType getType();
}
