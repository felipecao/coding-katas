package br.felipecao.kata.usecase;

import br.felipecao.kata.core.domain.*;
import br.felipecao.kata.core.support.Amount;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class PrintAccountStatementShould {

    private static final String EXPECTED_HEADER = "date || transaction amount || balance after transaction";

    AccountFactory accountFactory;
    TransactionFactory transactionFactory;
    PrintAccountStatement useCase;
    PrintWriter output;

    @Before
    public void setup() {
        accountFactory = new AccountFactory();
        transactionFactory = new TransactionFactory();
        output = mock(PrintWriter.class);
        useCase = new PrintAccountStatementImpl(output);
    }

    @Test
    public void print_an_empty_statement_when_account_has_no_transactions() {
        Account account = accountFactory.newAccount();

        useCase.execute(account);

        verify(output, times(1)).println(EXPECTED_HEADER);
    }

    @Test
    public void print_a_statement_with_one_line_when_account_has_one_deposit_transaction() {
        Account account = accountFactory.newAccount();
        LocalDate date = LocalDate.now();
        Amount amount = Amount.of(100);
        TransactionType deposit = TransactionType.DEPOSIT;
        Transaction transaction = createTransactionOfAmountAndTypeOnDate(amount, deposit, date);

        account.addTransaction(transaction);

        String expectedReport = expectReportWithDepositOfAmountOnDate(amount, date);

        useCase.execute(account);

        verify(output, times(1)).println(expectedReport);
    }

    @Test
    public void print_a_statement_with_one_line_when_account_has_one_withdraw_transaction() {
        Account account = accountFactory.newAccount();
        LocalDate date = LocalDate.now();
        Amount amount = Amount.of(100);
        TransactionType withdraw = TransactionType.WITHDRAW;
        Transaction transaction = createTransactionOfAmountAndTypeOnDate(amount, withdraw, date);

        account.addTransaction(transaction);

        String expectedReport = expectReportWithWithdrawOfAmountOnDate(amount, date);

        useCase.execute(account);

        verify(output, times(1)).println(expectedReport);
    }

    @Test
    public void print_a_statement_with_one_deposit_and_one_withdraw() {
        Account account = accountFactory.newAccount();

        LocalDate depositDate = LocalDate.now();
        Amount depositAmount = Amount.of(100);
        TransactionType deposit = TransactionType.DEPOSIT;
        Transaction depositTransaction = createTransactionOfAmountAndTypeOnDate(depositAmount, deposit, depositDate);

        LocalDate withdrawDate = LocalDate.now().plusDays(1);
        Amount withdrawAmount = Amount.of(75);
        TransactionType withdraw = TransactionType.WITHDRAW;
        Transaction withdrawTransaction = createTransactionOfAmountAndTypeOnDate(withdrawAmount, withdraw, withdrawDate);

        account.addTransaction(depositTransaction);
        account.addTransaction(withdrawTransaction);

        String expectedReport = expectReportWithDepositAndWithdrawOfAmountOnDates(depositAmount, depositDate,
                withdrawAmount, withdrawDate);

        useCase.execute(account);

        verify(output, times(1)).println(expectedReport);
    }

    private Transaction createTransactionOfAmountAndTypeOnDate(Amount amount, TransactionType type, LocalDate date) {
        return transactionFactory.newTransaction(date, amount, type);
    }

    private String expectReportWithDepositOfAmountOnDate(Amount amount, LocalDate date) {
        String report = EXPECTED_HEADER;

        report += "\n" + date + " || " + amount.getValue() + " || " + amount.getValue();

        return report;
    }

    private String expectReportWithWithdrawOfAmountOnDate(Amount amount, LocalDate date) {
        String report = EXPECTED_HEADER;

        report += "\n" + date + " || -" + amount.getValue() + " || " + (-1) * amount.getValue();

        return report;
    }

    private String expectReportWithDepositAndWithdrawOfAmountOnDates(Amount depositAmount, LocalDate depositDate,
                                                                     Amount withdrawAmount, LocalDate withdrawDate) {
        String report = EXPECTED_HEADER;

        report += "\n" + depositDate + " || " + depositAmount.getValue() + " || " + depositAmount.getValue();
        report += "\n" + withdrawDate + " || -" + withdrawAmount.getValue() + " || " + (depositAmount.getValue() - withdrawAmount.getValue());

        return report;
    }
}
