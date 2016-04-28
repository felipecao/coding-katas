package br.felipecao.kata.usecase;

import br.felipecao.kata.core.domain.Account;
import br.felipecao.kata.core.domain.Transaction;
import br.felipecao.kata.core.domain.TransactionType;
import br.felipecao.kata.core.support.Amount;

import java.io.PrintWriter;

public class PrintAccountStatementImpl implements PrintAccountStatement {

    private static final String HEADER = "date || transaction amount || balance after transaction";
    private static final String ROW_FORMAT = "\n%s || %s || %s";

    private PrintWriter out;

    public PrintAccountStatementImpl(PrintWriter pw) {
        out = pw;
    }

    @Override
    public void execute(Account account) {
        StringBuffer report = new StringBuffer();
        Amount updatedBalance = account.getBalance();

        report.append(HEADER);

        for(Transaction t: account.getTransactions()) {
            updatedBalance = calculateBalanceForTransactionType(updatedBalance, t.getAmount(), t.getType());
            report.append(
                    String.format(ROW_FORMAT,
                    t.getDate(),
                    outputAmountValueForTransactionType(t.getAmount(), t.getType()), // TODO too many dots!
                    updatedBalance.getValue()));
        }

        out.println(report.toString());
    }

    private String outputAmountValueForTransactionType(Amount amount, TransactionType type) {
        String value = amount.toString();

        if(TransactionType.WITHDRAW.equals(type)) { // TODO should only have one dot
            value = "-" + value;
        }

        return value;
    }

    private Amount calculateBalanceForTransactionType(Amount currentBalance, Amount transactionAmount, TransactionType type) {
        if (TransactionType.DEPOSIT.equals(type)) {
            return currentBalance.plus(transactionAmount);
        }

        return currentBalance.minus(transactionAmount);
    }
}
