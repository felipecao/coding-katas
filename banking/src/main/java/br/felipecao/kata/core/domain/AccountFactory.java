package br.felipecao.kata.core.domain;

/**
 * Created by felipe on 4/26/16.
 */
public class AccountFactory {
    public Account newAccount() {
        return new AccountImpl();
    }
}
