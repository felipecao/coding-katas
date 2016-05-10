package fizz.buzz;

import org.hamcrest.core.StringEndsWith;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertEquals;

/**
 * My approach to the problem:
 *
 * Hey, Tobias! Hope we have fun doing this kata!
 *
 * So, as per the problem description, we're supposed to print a sequence of numbers from 1 to 100, replacing some
 * of the numbers for "Fizz", "Buzz" or "FizzBuzz" whenever applicable, as you already know.
 *
 * My idea here is to do something incremental. In other words, instead of writing tests for a class that prints the
 * entire sequence from 1 to 100 (which would be quite hard to test), I propose we the concept of an 'upper boundary'.
 *
 * By 'upper boundary' I mean the maximum number we want to check for fizz's & buzz's.
 *
 * For instance:
 * * if our 'upper boundary' is 1, the output should be "1".
 * * if our 'upper boundary' is 2, the output should be "1 2".
 * * if our 'upper boundary' is 3, the output should be "1 2 Fizz".
 * * so on, so forth...
 *
 * This way, we can easily start testing individual cases and incrementally take care of the others. I hope you agree
 * with this approach. If not, let me know and let's figure out a better approach together! If you want to get a hold
 * of myself, my e-mail is felipe.carvalho@gmail.com and my Skype handle is felipecao.
 *
 */
public class FizzBuzzShould {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception {
        fizzBuzz = new FizzBuzz();
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_when_upper_boundary_is_0() {
        Integer upperBoundary = 0;
        fizzBuzz.fizzBuzz(upperBoundary);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_when_upper_boundary_is_not_provided() {
        Integer upperBoundary = null;
        fizzBuzz.fizzBuzz(upperBoundary);
    }

    @Test
    public void say_1_when_upper_boundary_is_1() {
        Integer upperBoundary = 1;
        String expected = "1";
        String actual = fizzBuzz.fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void say_1_2_when_upper_boundary_is_2() {
        Integer upperBoundary = 2;
        String expected = "1 2";
        String actual = fizzBuzz.fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void say_1_2_Fizz_when_upper_boundary_is_3() {
        Integer upperBoundary = 3;
        String expected = "1 2 Fizz";
        String actual = fizzBuzz.fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void have_Buzz_as_last_word_when_upper_boundary_is_5() {
        Integer upperBoundary = 5;
        String expectedEnd = "Buzz";
        String actual = fizzBuzz.fizzBuzz(upperBoundary);

        assertThat(actual, StringEndsWith.endsWith(expectedEnd));
    }

    @Test
    public void say_1_2_Fizz_4_Buzz_when_upper_boundary_is_5() {
        Integer upperBoundary = 5;
        String expected = "1 2 Fizz 4 Buzz";
        String actual = fizzBuzz.fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void have_Fizz_as_last_word_when_upper_boundary_is_6() {
        Integer upperBoundary = 6;
        String expectedEnd = "Fizz";
        String actual = fizzBuzz.fizzBuzz(upperBoundary);

        assertThat(actual, StringEndsWith.endsWith(expectedEnd));
    }

    @Test
    public void say_1_2_Fizz_4_Buzz_Fizz_7_8_Fizz_when_upper_boundary_is_9() {
        Integer upperBoundary = 9;
        String expected = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz";
        String actual = fizzBuzz.fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void have_Buzz_as_last_word_when_upper_boundary_is_10() {
        Integer upperBoundary = 10;
        String expectedEnd = "Buzz";
        String actual = fizzBuzz.fizzBuzz(upperBoundary);

        assertThat(actual, StringEndsWith.endsWith(expectedEnd));
    }

    @Test
    public void say_Fizz_Buzz_when_upper_boundary_is_15() {
        Integer upperBoundary = 15;
        String expected = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz";
        String actual = fizzBuzz.fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void say_Fizz_Buzz_when_upper_boundary_is_30() {
        Integer upperBoundary = 30;
        String expected = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz";
        String actual = fizzBuzz.fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void say_Fizz_Buzz_when_upper_boundary_is_100() {
        Integer upperBoundary = 100;
        String expected =
                 "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz" +
                 " 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz" +
                 " Fizz 22 23 Fizz Buzz 26 Fizz 28 29 FizzBuzz" +
                 " 31 32 Fizz 34 Buzz Fizz 37 38 Fizz Buzz" +
                 " 41 Fizz 43 44 FizzBuzz 46 47 Fizz 49 Buzz" +
                 " Fizz 52 53 Fizz Buzz 56 Fizz 58 59 FizzBuzz" +
                 " 61 62 Fizz 64 Buzz Fizz 67 68 Fizz Buzz" +
                 " 71 Fizz 73 74 FizzBuzz 76 77 Fizz 79 Buzz" +
                 " Fizz 82 83 Fizz Buzz 86 Fizz 88 89 FizzBuzz" +
                 " 91 92 Fizz 94 Buzz Fizz 97 98 Fizz Buzz";

        String actual = fizzBuzz.fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

}
