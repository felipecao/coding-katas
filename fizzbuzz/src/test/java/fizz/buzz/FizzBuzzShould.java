package fizz.buzz;

import org.hamcrest.core.StringEndsWith;
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

    private String fizzBuzz(Integer upperBoundary) {

        if(isIllegalArgument(upperBoundary)) {
            throw new IllegalArgumentException();
        }

        String result = "1";

        for(int i = 2; i <= upperBoundary; i++) {
            if ((0 == (i % 3)) && (0 == (i % 5))) {
                result += " FizzBuzz";
                continue;
            }
            if (0 == (i % 3)) {
                result += " Fizz";
                continue;
            }
            if (0 == (i % 5)) {
                result += " Buzz";
                continue;
            }
            result += " " + i;
        }

        return result;
    }

    private boolean isIllegalArgument(Integer upperBoundary) {
        return null == upperBoundary || 0 == upperBoundary;
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_when_upper_boundary_is_0() {
        Integer upperBoundary = 0;
        fizzBuzz(upperBoundary);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_when_upper_boundary_is_not_provided() {
        Integer upperBoundary = null;
        fizzBuzz(upperBoundary);
    }

    @Test
    public void say_1_when_upper_boundary_is_1() {
        Integer upperBoundary = 1;
        String expected = "1";
        String actual = fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void say_1_2_when_upper_boundary_is_2() {
        Integer upperBoundary = 2;
        String expected = "1 2";
        String actual = fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void say_1_2_Fizz_when_upper_boundary_is_3() {
        Integer upperBoundary = 3;
        String expected = "1 2 Fizz";
        String actual = fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void have_Buzz_as_last_word_when_upper_boundary_is_5() {
        Integer upperBoundary = 5;
        String expectedEnd = "Buzz";
        String actual = fizzBuzz(upperBoundary);

        assertThat(actual, StringEndsWith.endsWith(expectedEnd));
    }

    @Test
    public void say_1_2_Fizz_4_Buzz_when_upper_boundary_is_5() {
        Integer upperBoundary = 5;
        String expected = "1 2 Fizz 4 Buzz";
        String actual = fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void have_Fizz_as_last_word_when_upper_boundary_is_6() {
        Integer upperBoundary = 6;
        String expectedEnd = "Fizz";
        String actual = fizzBuzz(upperBoundary);

        assertThat(actual, StringEndsWith.endsWith(expectedEnd));
    }

    @Test
    public void say_1_2_Fizz_4_Buzz_Fizz_7_8_Fizz_when_upper_boundary_is_9() {
        Integer upperBoundary = 9;
        String expected = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz";
        String actual = fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

    @Test
    public void have_Buzz_as_last_word_when_upper_boundary_is_10() {
        Integer upperBoundary = 10;
        String expectedEnd = "Buzz";
        String actual = fizzBuzz(upperBoundary);

        assertThat(actual, StringEndsWith.endsWith(expectedEnd));
    }

    @Test
    public void say_Fizz_Buzz_when_upper_boundary_is_15() {
        Integer upperBoundary = 15;
        String expected = "1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz";
        String actual = fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }

}
