package fizz.buzz.number.factory;

import fizz.buzz.number.*;
import fizz.buzz.number.Number;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BuzzNumberFactoryShould {

    BuzzNumberFactory factory;
    NumberFactory successor;

    @Before
    public void setup() {
        factory = new BuzzNumberFactory();

        successor = mock(NumberFactory.class);
        factory.setSuccessor(successor);
    }

    @Test
    public void return_a_buzz_if_input_is_divisible_by_5() {
        Integer input = 15;
        Number output = factory.build(input);

        assertEquals(new BuzzNumber(15), output);
    }

    @Test
    public void delegate_to_successor_if_input_is_not_divisible_by_5() {
        Integer input = 16;

        when(successor.build(input)).thenReturn(new RegularNumber(16));

        Number output = factory.build(input);

        assertEquals(new RegularNumber(16), output);
        verify(successor, times(1)).build(input);
    }
}
