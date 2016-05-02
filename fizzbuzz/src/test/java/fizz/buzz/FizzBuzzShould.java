package fizz.buzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzShould {

    private String fizzBuzz(Integer upperBoundary) {
        return null;
    }

    @Test
    public void say_1_when_upper_boundary_is_one() {
        Integer upperBoundary = 1;
        String expected = "1";
        String actual = fizzBuzz(upperBoundary);

        assertEquals(expected, actual);
    }
}
