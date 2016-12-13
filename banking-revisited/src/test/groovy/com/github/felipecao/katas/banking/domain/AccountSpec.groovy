package com.github.felipecao.katas.banking.domain

import com.github.felipecao.katas.banking.support.Amount
import spock.lang.Specification

class AccountSpec extends Specification {

    private Account account

    def setup() {
        account = new AccountImpl()
    }

    def "an account's balance is immutable"() {
        when:
        account.balance.plus(Amount.of(20))

        then:
        Amount.of(0) == account.balance
    }
}
