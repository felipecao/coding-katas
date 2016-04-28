package br.felipecao.kata.usecase;

import br.felipecao.kata.core.domain.Account;

/**
 * Created by felipe on 4/27/16.
 */
public interface PrintAccountStatement {
    void execute(Account account);
}
