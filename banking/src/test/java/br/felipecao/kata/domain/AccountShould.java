package br.felipecao.kata.domain;

import br.felipecao.kata.domain.Account;
import br.felipecao.kata.domain.AccountImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class AccountShould {

    Account account;

    @Before
    public void setup() {
        account = AccountImpl.newAccount();
    }

    @Test
    public void be_created_with_balance_zero() {
        assertEquals(0, account.getBalance().intValue());
    }

    @Test
    public void have_a_balance_that_is_equal_to_deposited_amount() {
        Integer previousBalance = account.getBalance();
        Integer depositedAmount = new Random().nextInt(500);
        Integer expectedBalance = previousBalance + depositedAmount;

        account.deposit(depositedAmount);

        assertEquals(expectedBalance.intValue(), account.getBalance().intValue());
    }

    @Test
    public void have_a_balance_that_is_equal_to_two_consecutive_deposits() {
        Integer previousBalance = account.getBalance();
        Integer firstAmount = new Random().nextInt(500);
        Integer secondAmount = new Random().nextInt(500);
        Integer expectedBalance = previousBalance + firstAmount + secondAmount;

        account.deposit(firstAmount);
        account.deposit(secondAmount);

        assertEquals(expectedBalance.intValue(), account.getBalance().intValue());
    }

    @Test
    public void have_a_negative_balance_that_is_equal_to_withdrawn_amount() {
        Integer previousBalance = account.getBalance();
        Integer withdrawnAmount = new Random().nextInt(500);
        Integer expectedBalance = previousBalance - withdrawnAmount;

        account.withdraw(withdrawnAmount);

        assertEquals(expectedBalance.intValue(), account.getBalance().intValue());
    }

    @Test
    public void have_a_negative_balance_that_is_equal_to_two_consecutive_withdrawn_amounts() {
        Integer previousBalance = account.getBalance();
        Integer firstAmount = new Random().nextInt(500);
        Integer secondAmount = new Random().nextInt(500);
        Integer expectedBalance = previousBalance - firstAmount - secondAmount;

        account.withdraw(firstAmount);
        account.withdraw(secondAmount);

        assertEquals(expectedBalance.intValue(), account.getBalance().intValue());
    }

    @Test
    public void have_a_balance_that_complies_with_3_deposits_and_2_withdraws() {
        Integer previousBalance = account.getBalance();
        Integer firstDeposit = new Random().nextInt(500);
        Integer secondDeposit = new Random().nextInt(500);
        Integer thirdDeposit = new Random().nextInt(500);
        Integer firstWithdraw = new Random().nextInt(500);
        Integer secondWithdraw = new Random().nextInt(500);
        Integer expectedBalance = previousBalance + firstDeposit + secondDeposit + thirdDeposit - firstWithdraw - secondWithdraw;

        account.deposit(firstDeposit);
        account.deposit(secondDeposit);
        account.deposit(thirdDeposit);
        account.withdraw(firstWithdraw);
        account.withdraw(secondWithdraw);

        assertEquals(expectedBalance.intValue(), account.getBalance().intValue());
    }
}
