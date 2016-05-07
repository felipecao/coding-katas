package fizz.buzz.number;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class NumberFactoryShould {

    NumberFactory factory;

    @Before
    public void setup() {
        factory = new NumberFactory();
    }

    @Test
    public void build_a_regular_number_for_input_1() {
        Integer input = 1;
        Number expectedNumber = new RegularNumber(input);
        Number actualNumber = factory.build(input);

        assertEquals(expectedNumber, actualNumber);
        assertEquals(expectedNumber.getClass(), actualNumber.getClass());
        assertEquals(input.toString(), actualNumber.toString());
    }

    @Test
    @DataProvider({
            "3", "6", "9", "12", "18", "21", "24", "27"
    })
    public void build_a_fizz_number_for_input_divisible_by_3_and_not_divisible_by_5(Integer input) {
        Number expectedNumber = new FizzNumber(input);
        Number actualNumber = factory.build(input);

        assertEquals(expectedNumber, actualNumber);
        assertEquals(expectedNumber.getClass(), actualNumber.getClass());
        assertEquals("Fizz", actualNumber.toString());
    }

    @Test
    @DataProvider({
            "5", "10", "20", "25", "35", "40", "50", "55"
    })
    public void build_a_buzz_number_for_input_divisible_by_5_and_not_divisible_by_3(Integer input) {
        Number expectedNumber = new BuzzNumber(input);
        Number actualNumber = factory.build(input);

        assertEquals(expectedNumber, actualNumber);
        assertEquals(expectedNumber.getClass(), actualNumber.getClass());
        assertEquals("Buzz", actualNumber.toString());
    }

    @Test
    @DataProvider({
            "15", "30", "45", "60", "75", "90"
    })
    public void build_a_fizz_buzz_number_for_input_divisible_by_both_3_and_5(Integer input) {
        Number expectedNumber = new FizzBuzzNumber(input);
        Number actualNumber = factory.build(input);

        assertEquals(expectedNumber, actualNumber);
        assertEquals(expectedNumber.getClass(), actualNumber.getClass());
        assertEquals("FizzBuzz", actualNumber.toString());
    }
}