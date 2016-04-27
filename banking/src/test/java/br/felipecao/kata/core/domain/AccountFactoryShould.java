package br.felipecao.kata.core.domain;

import br.felipecao.kata.core.support.Amount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountFactoryShould {

    @Test
    public void create_an_account_with_balance_zero() {
        AccountFactory factory = new AccountFactory();
        Account account = factory.newAccount();

        assertEquals(Amount.ZERO, account.getBalance());
    }
}
