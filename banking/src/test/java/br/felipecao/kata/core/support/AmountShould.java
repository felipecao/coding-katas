package br.felipecao.kata.core.support;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class AmountShould {

    @Test
    public void have_a_value_that_matches_its_input_integer() {
        Integer amountValue = new Random().nextInt(500);
        Amount amount = Amount.of(amountValue);

        assertEquals(amountValue, amount.getValue());
    }

    @Test
    public void satisfy_equals() {
        Integer amountValue = new Random().nextInt(500);
        Amount firstAmount = Amount.of(amountValue);
        Amount anotherAmount = Amount.of(amountValue);

        assertEquals(firstAmount, anotherAmount);
    }

    @Test
    public void satisfy_equals_with_negative_numbers() {
        Integer amountValue = (-1) * new Random().nextInt(500);
        Amount firstAmount = Amount.of(amountValue);
        Amount anotherAmount = Amount.of(amountValue);

        assertEquals(firstAmount, anotherAmount);
    }

    @Test
    public void be_positive_after_sum_of_positive_numbers() {
        Integer initialValue = new Random().nextInt(500);
        Amount firstAmount = Amount.of(initialValue);
        Amount anotherAmount = firstAmount.plus(firstAmount);

        assertEquals(Amount.of(initialValue * 2), anotherAmount);
        assertTrue(anotherAmount.getValue() > 0);
    }

    @Test
    public void be_negative_after_sum_of_negative_numbers() {
        Integer initialValue = (-1) * new Random().nextInt(500);
        Amount firstAmount = Amount.of(initialValue);
        Amount anotherAmount = firstAmount.plus(firstAmount);

        assertEquals(Amount.of(initialValue * 2), anotherAmount);
        assertTrue(anotherAmount.getValue() < 0);
    }

    @Test
    public void be_positive_after_sum_of_negative_with_greater_positive() {
        Amount minus50 = Amount.of(-50);
        Amount anotherAmount = minus50.plus(Amount.of(60));

        assertEquals(Amount.of(10), anotherAmount);
    }

    @Test
    public void not_be_the_same_object_after_plus() {
        Integer initialValue = new Random().nextInt(500);
        Amount firstAmount = Amount.of(initialValue);
        Amount anotherAmount = firstAmount.plus(firstAmount);

        assertNotSame(firstAmount, anotherAmount);
        assertNotEquals(firstAmount, anotherAmount);
        assertEquals(Amount.of(initialValue * 2), anotherAmount);
    }

    @Test
    public void not_be_the_same_object_after_minus() {
        Integer initialValue = new Random().nextInt(500);
        Amount firstAmount = Amount.of(initialValue);
        Amount anotherAmount = firstAmount.minus(firstAmount);

        assertNotSame(firstAmount, anotherAmount);
        assertNotEquals(firstAmount, anotherAmount);
        assertEquals(Amount.ZERO, anotherAmount);
    }

    @Test
    public void be_zero_when_decreasing_the_initial_amount() {
        Integer initialValue = new Random().nextInt(500);
        Amount firstAmount = Amount.of(initialValue);
        Amount anotherAmount = firstAmount.minus(firstAmount);

        assertEquals(Amount.ZERO, anotherAmount);
    }

    @Test
    public void be_positive_when_decreasing_400_from_500() {
        Amount firstAmount = Amount.of(500);
        Amount anotherAmount = firstAmount.minus(Amount.of(400));

        assertEquals(Amount.of(100), anotherAmount);
    }

    @Test
    public void be_negative_when_decreasing_500_from_400() {
        Amount firstAmount = Amount.of(400);
        Amount anotherAmount = firstAmount.minus(Amount.of(500));

        assertEquals(Amount.of(-100), anotherAmount);
    }

    @Test
    public void be_positive_when_decreasing_minus_500_from_minus_400() {
        Amount firstAmount = Amount.of(-400);
        Amount anotherAmount = firstAmount.minus(Amount.of(-500));

        assertEquals(Amount.of(100), anotherAmount);
    }
}
