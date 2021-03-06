package fizz.buzz.number;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class FizzNumberShould {

    @Test(expected = IllegalArgumentException.class)
    public void throw_an_exception_if_instantiate_with_null_value() {
        new FizzNumber(null);
    }

    @Test
    public void output_Fizz_as_string() {
        Integer input = new Random().nextInt(500);
        String expectedOutput = "Fizz";
        FizzNumber number = new FizzNumber(input);

        assertEquals(expectedOutput, number.toString());
    }

    @Test
    public void be_sorted_according_to_its_internal_value() {
        FizzNumber one = new FizzNumber(1);
        FizzNumber two = new FizzNumber(2);
        SortedSet<Number> sortedNumbers = asSortedSet(two, one);

        assertEquals(one, sortedNumbers.first());
        assertEquals(two, sortedNumbers.last());
    }

    @Test
    public void be_equal_to_another_instance_with_same_value() {
        Integer value = 1;
        FizzNumber one = new FizzNumber(value);
        FizzNumber other = new FizzNumber(value);

        assertEquals(one, other);
    }

    private SortedSet<Number> asSortedSet(Number... numbers) {
        return new TreeSet<Number>(Arrays.asList(numbers));
    }
}