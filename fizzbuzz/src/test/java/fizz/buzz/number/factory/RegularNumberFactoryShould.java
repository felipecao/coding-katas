package fizz.buzz.number.factory;

import fizz.buzz.number.Number;
import fizz.buzz.number.RegularNumber;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class RegularNumberFactoryShould {

    RegularNumberFactory factory;

    @Before
    public void setup() {
        factory = new RegularNumberFactory();
    }

    @Test
    public void return_a_regular_number_for_whatever_input() {
        Integer input = new Random().nextInt(500);
        Number output = factory.build(input);

        assertEquals(new RegularNumber(input), output);
    }
}
