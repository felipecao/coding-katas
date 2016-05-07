package fizz.buzz.number;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RegularNumberShould {

    @Test(expected = IllegalArgumentException.class)
    public void throw_an_exception_if_instantiate_with_null_value() {
        new RegularNumber(null);
    }

    @Test
    public void output_its_internal_value_as_string() {
        Integer input = new Random().nextInt(500);
        String expectedOutput = input.toString();
        RegularNumber number = new RegularNumber(input);

        assertEquals(expectedOutput, number.toString());
    }

    @Test
    public void be_sorted_according_to_its_internal_value() {
        RegularNumber one = new RegularNumber(1);
        RegularNumber two = new RegularNumber(2);
        SortedSet<Number> sortedNumbers = asSortedSet(two, one);

        assertEquals(one, sortedNumbers.first());
        assertEquals(two, sortedNumbers.last());
    }

    @Test
    public void be_equal_to_another_instance_with_same_value() {
        Integer value = 1;
        RegularNumber one = new RegularNumber(value);
        RegularNumber other = new RegularNumber(value);

        assertEquals(one, other);
    }

    @Test
    public void not_be_equal_to_fizz_number_with_same_internal_value() {
        Integer value = 1;
        RegularNumber one = new RegularNumber(value);
        FizzNumber other = new FizzNumber(value);

        assertNotEquals(one, other);
    }

    @Test
    public void not_be_equal_to_buzz_number_with_same_internal_value() {
        Integer value = 1;
        RegularNumber one = new RegularNumber(value);
        BuzzNumber other = new BuzzNumber(value);

        assertNotEquals(one, other);
    }

    @Test
    public void not_be_equal_to_fizz_buzz_number_with_same_internal_value() {
        Integer value = 1;
        RegularNumber one = new RegularNumber(value);
        FizzBuzzNumber other = new FizzBuzzNumber(value);

        assertNotEquals(one, other);
    }

    private SortedSet<Number> asSortedSet(Number... numbers) {
        return new TreeSet<Number>(Arrays.asList(numbers));
    }
}