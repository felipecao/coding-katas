package br.felipecao.kata.domain;

public interface Account {

    Integer getBalance();

    void deposit(Integer amount);

    void withdraw(Integer amount);
}
