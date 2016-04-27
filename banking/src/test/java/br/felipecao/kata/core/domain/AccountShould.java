package br.felipecao.kata.core.domain;

import br.felipecao.kata.core.support.Amount;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class AccountShould {

    Account account;

    @Before
    public void setup() {
        account = new AccountImpl();
    }

    @Test
    public void be_created_with_balance_zero() {
        assertEquals(Amount.ZERO, account.getBalance());
    }

    @Test
    public void have_a_balance_that_is_equal_to_deposited_amount() {
        Integer previousBalance = account.getBalance().getValue();
        Integer depositedAmount = new Random().nextInt(500);
        Integer expectedBalance = previousBalance + depositedAmount;

        account.deposit(Amount.of(depositedAmount));

        assertEquals(expectedBalance.intValue(), account.getBalance().getValue().intValue());
    }

    @Test
    public void have_a_balance_that_is_equal_to_two_consecutive_deposits() {
        Integer previousBalance = account.getBalance().getValue();
        Integer firstAmount = new Random().nextInt(500);
        Integer secondAmount = new Random().nextInt(500);
        Integer expectedBalance = previousBalance + firstAmount + secondAmount;

        account.deposit(Amount.of(firstAmount));
        account.deposit(Amount.of(secondAmount));

        assertEquals(expectedBalance.intValue(), account.getBalance().getValue().intValue());
    }

    @Test
    public void have_a_negative_balance_that_is_equal_to_withdrawn_amount() {
        Integer previousBalance = account.getBalance().getValue();
        Integer withdrawnAmount = new Random().nextInt(500);
        Integer expectedBalance = previousBalance - withdrawnAmount;

        account.withdraw(Amount.of(withdrawnAmount));

        assertEquals(expectedBalance.intValue(), account.getBalance().getValue().intValue());
    }

    @Test
    public void have_a_negative_balance_that_is_equal_to_two_consecutive_withdrawn_amounts() {
        Integer previousBalance = account.getBalance().getValue();
        Integer firstAmount = new Random().nextInt(500);
        Integer secondAmount = new Random().nextInt(500);
        Integer expectedBalance = previousBalance - firstAmount - secondAmount;

        account.withdraw(Amount.of(firstAmount));
        account.withdraw(Amount.of(secondAmount));

        assertEquals(expectedBalance.intValue(), account.getBalance().getValue().intValue());
    }

    @Test
    public void have_a_balance_that_complies_with_3_deposits_and_2_withdraws() {
        Integer previousBalance = account.getBalance().getValue();
        Integer firstDeposit = new Random().nextInt(500);
        Integer secondDeposit = new Random().nextInt(500);
        Integer thirdDeposit = new Random().nextInt(500);
        Integer firstWithdraw = new Random().nextInt(500);
        Integer secondWithdraw = new Random().nextInt(500);
        Integer expectedBalance = previousBalance + firstDeposit + secondDeposit + thirdDeposit - firstWithdraw - secondWithdraw;

        account.deposit(Amount.of(firstDeposit));
        account.deposit(Amount.of(secondDeposit));
        account.deposit(Amount.of(thirdDeposit));
        account.withdraw(Amount.of(firstWithdraw));
        account.withdraw(Amount.of(secondWithdraw));

        assertEquals(expectedBalance.intValue(), account.getBalance().getValue().intValue());
    }
}
