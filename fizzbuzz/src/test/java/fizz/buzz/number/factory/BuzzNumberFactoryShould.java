package fizz.buzz.number.factory;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import fizz.buzz.number.FizzNumber;
import fizz.buzz.number.Number;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(DataProviderRunner.class)
public class BuzzNumberFactoryShould {

    private BuzzNumberFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new BuzzNumberFactory();
    }

    @Test
    @DataProvider({
            "1", "2", "3", "4", "6", "7", "8", "9", "11", "12"
    })
    public void return_null_for_integer_1_to_12_without_5_and_10(Integer input) {
        Number actualNumber = factory.build(input);

        assertEquals(null, actualNumber);
    }

    @Test
    @DataProvider({
            "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"
    })
    public void return_Buzz_for_integer_multiples_of_5(Integer input) {
        Number actualNumber = factory.build(input);

        assertEquals("Buzz", actualNumber.toString());
    }
}