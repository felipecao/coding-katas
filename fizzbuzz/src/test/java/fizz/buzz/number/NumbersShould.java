package fizz.buzz.number;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;

import static org.junit.Assert.*;

public class NumbersShould {

    Numbers numbers;

    @Before
    public void setup() {
        numbers = new Numbers();
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
        SortedSet<Number> numbers = this.numbers.fetch(1);

        assertEquals(1, numbers.size());
        assertEquals(new RegularNumber(1), numbers.first());
    }

    @Test
    public void return_a_collection_with_two_numbers_if_upper_boundary_is_two() {
        SortedSet<Number> numbers = this.numbers.fetch(2);

        assertEquals(2, numbers.size());
        assertEquals(new RegularNumber(1), numbers.first());
        assertEquals(new RegularNumber(2), numbers.last());
    }

    @Test
    public void return_a_collection_with_N_numbers_if_upper_boundary_is_N() {
        Integer totalElements = new Random().nextInt(50);
        SortedSet<Number> numbers = this.numbers.fetch(totalElements);

        assertEquals(totalElements.intValue(), numbers.size());

        int counter = 1;
        Iterator<Number> itr = numbers.iterator();

        while (itr.hasNext()) {
            assertEquals(new RegularNumber(counter++), itr.next());
        }
    }
}