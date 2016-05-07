package fizz.buzz.number;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

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

    private SortedSet<Number> asSortedSet(Number... numbers) {
        return new TreeSet<Number>(Arrays.asList(numbers));
    }
}