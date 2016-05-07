package fizz.buzz.number;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class FizzBuzzNumberShould {
    
    @Test(expected = IllegalArgumentException.class)
    public void throw_an_exception_if_instantiate_with_null_value() {
        new FizzBuzzNumber(null);
    }

    @Test
    public void output_Fizz_as_string() {
        Integer input = new Random().nextInt(500);
        String expectedOutput = "FizzBuzz";
        FizzBuzzNumber number = new FizzBuzzNumber(input);

        assertEquals(expectedOutput, number.toString());
    }

    @Test
    public void be_sorted_according_to_its_internal_value() {
        FizzBuzzNumber one = new FizzBuzzNumber(1);
        FizzBuzzNumber two = new FizzBuzzNumber(2);
        SortedSet<Number> sortedNumbers = asSortedSet(two, one);

        assertEquals(one, sortedNumbers.first());
        assertEquals(two, sortedNumbers.last());
    }

    @Test
    public void be_equal_to_another_instance_with_same_value() {
        Integer value = 1;
        FizzBuzzNumber one = new FizzBuzzNumber(value);
        FizzBuzzNumber other = new FizzBuzzNumber(value);

        assertEquals(one, other);
    }

    private SortedSet<Number> asSortedSet(Number... numbers) {
        return new TreeSet<Number>(Arrays.asList(numbers));
    }
}