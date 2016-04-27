package br.felipecao.kata.core.domain;

import br.felipecao.kata.core.support.Amount;

public interface Account {

    Amount getBalance();

    void deposit(Amount amount);

    void withdraw(Amount amount);
}
