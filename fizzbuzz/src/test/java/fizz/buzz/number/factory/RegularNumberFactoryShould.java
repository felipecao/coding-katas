package fizz.buzz.number.factory;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import fizz.buzz.number.Number;
import fizz.buzz.number.RegularNumber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class RegularNumberFactoryShould {

    private RegularNumberFactory factory;

    @Before
    public void setUp() throws Exception {
        factory = new RegularNumberFactory();
    }

    @Test
    @DataProvider({
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
    })
    public void return_regular_number_for_integer_1_to_12(Integer input) {
        Number expectedNumber = new RegularNumber(input);
        Number actualNumber = factory.build(input);

        assertEquals(expectedNumber, actualNumber);
    }
}