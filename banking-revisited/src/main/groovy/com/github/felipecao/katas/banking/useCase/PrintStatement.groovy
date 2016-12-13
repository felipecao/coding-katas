package com.github.felipecao.katas.banking.useCase

import com.github.felipecao.katas.banking.domain.Account
import com.github.felipecao.katas.banking.domain.Transaction

class PrintStatement {

    public static final String HEADER = "Date | Transaction amount | Balance after transaction\n-----------------------------------------------------\n"

    private Account account
    private PrintStream console

    PrintStatement(Account account, PrintStream console) {
        this.account = account
        this.console = console
    }

    void execute() {
        printHeader()

        account.forEachTransaction { Transaction t ->
            console.println("${t.date} | ${t.amount} | ${t.balanceAfterTransaction}".toString())
        }
    }

    private void printHeader() {
        console.println(HEADER)
    }

}
