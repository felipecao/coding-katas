package br.felipecao.kata.core.domain;

import br.felipecao.kata.core.support.Amount;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Random;

import static org.junit.Assert.*;

public class TransactionFactoryShould {

    TransactionFactory factory;

    @Before
    public void setup() {
        factory = new TransactionFactory();
    }

    @Test(expected = IllegalArgumentException.class)
    public void not_create_a_transaction_instance_if_date_is_null() {
        factory.newTransaction(null, Amount.ZERO, TransactionType.DEPOSIT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void not_create_a_transaction_instance_if_amount_is_null() {
        factory.newTransaction(LocalDate.now(), null, TransactionType.DEPOSIT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void not_create_a_transaction_instance_if_type_is_null() {
        factory.newTransaction(LocalDate.now(), Amount.ZERO, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void not_create_a_transaction_instance_if_all_inputs_are_null() {
        factory.newTransaction(null, null, null);
    }

    @Test
    public void create_a_transaction_instance_with_same_date_and_amount_as_input() {
        LocalDate date = LocalDate.now();
        Amount amount = Amount.of(new Random().nextInt(500));
        TransactionType type = TransactionType.DEPOSIT;
        Transaction transaction = factory.newTransaction(date, amount, type);

        assertNotNull(transaction);
        assertEquals(date, transaction.getDate());
        assertEquals(amount, transaction.getAmount());
        assertEquals(type, transaction.getType());
    }
}