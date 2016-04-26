package br.felipecao.kata.domain;

/**
 * Created by felipe on 4/26/16.
 */
public class AccountImpl implements Account {

    private Integer balance = 0;

    private AccountImpl() {

    }

    @Override
    public Integer getBalance() {
        return balance;
    }

    @Override
    public void deposit(Integer amount) {
        balance += amount;
    }

    @Override
    public void withdraw(Integer amount) {
        balance -= amount;
    }

    public static Account newAccount() {
        return new AccountImpl();
    }
}
