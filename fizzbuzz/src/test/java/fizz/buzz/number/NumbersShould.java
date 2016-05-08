package fizz.buzz.number;

import fizz.buzz.number.factory.NumberFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class NumbersShould {

    NumbersImpl numbers;

    @Before
    public void setup() {
        numbers = new NumbersImpl(new NumberFactoryImpl());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_an_exception_if_we_try_to_build_numbers_based_on_null_upper_boundary() {
        numbers.fetch(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_an_exception_if_we_try_to_build_numbers_based_on_upper_boundary_zero() {
        numbers.fetch(0);
    }

    @Test
    public void return_a_collection_with_one_number_if_upper_boundary_is_one() {
        Integer upperBoundary = 1;
        SortedSet<Number> actualNumbers = numbers.fetch(upperBoundary);

        assertEquals(upperBoundary.intValue(), actualNumbers.size());
        assertEquals(new RegularNumber(upperBoundary), actualNumbers.first());
    }

    @Test
    public void return_a_collection_with_two_numbers_if_upper_boundary_is_two() {
        Integer upperBoundary = 2;
        SortedSet<Number> actualNumbers = numbers.fetch(upperBoundary);

        assertEquals(upperBoundary.intValue(), actualNumbers.size());
        assertEquals(new RegularNumber(1), actualNumbers.first());
        assertEquals(new RegularNumber(upperBoundary), actualNumbers.last());
    }

    @Test
    public void return_a_collection_with_N_numbers_if_upper_boundary_is_N() {
        Integer upperBoundary = new Random().nextInt(50);
        SortedSet<Number> expectedNumbers = expectedCollection(upperBoundary);
        SortedSet<Number> actualNumbers = numbers.fetch(upperBoundary);

        assertEquals(expectedNumbers.size(), actualNumbers.size());

        List<Number> expectedList = new ArrayList<Number>(expectedNumbers);
        List<Number> actualList = new ArrayList<Number>(actualNumbers);

        for (int i=0; i < upperBoundary; i++) {
            assertEquals(expectedList.get(i), actualList.get(i));
        }
    }

    private SortedSet<Number> expectedCollection(Integer upperBoundary) {
        SortedSet<Number> numbers = new TreeSet<Number>();
        Number numberToAdd = null;

        for (int i=1; i <= upperBoundary; i++) {

            if (i % 3 == 0 && i % 5 == 0) {
                numberToAdd = new FizzBuzzNumber(i);
            }
            else if (i % 3 == 0) {
                numberToAdd = new FizzNumber(i);
            }
            else if (i % 5 == 0) {
                numberToAdd = new BuzzNumber(i);
            }
            else {
                numberToAdd = new RegularNumber(i);
            }

            numbers.add(numberToAdd);
        }

        return numbers;
    }
}