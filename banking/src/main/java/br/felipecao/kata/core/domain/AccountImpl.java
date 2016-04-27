package br.felipecao.kata.core.domain;

import br.felipecao.kata.core.support.Amount;

class AccountImpl implements Account {

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
}
