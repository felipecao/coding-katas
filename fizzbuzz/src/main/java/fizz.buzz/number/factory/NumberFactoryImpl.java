package fizz.buzz.number.factory;

import fizz.buzz.number.*;
import fizz.buzz.number.Number;

public class NumberFactoryImpl implements NumberFactory {
    public Number build(Integer input) {

        if (input % 3 == 0 && input % 5 == 0) {
            return new FizzBuzzNumber(input);
        }

        if (input % 3 == 0) {
            return new FizzNumber(input);
        }

        Number result = buildBuzzNumber(input);
        if (null != result) {
            return result;
        }

        return new RegularNumber(input);
    }

    /**
     * @param input integer to build the number from
     * @return null if integer input is not supported
     */
    private Number buildBuzzNumber(Integer input) {
        Number result = null;
        if (input % 5 == 0) {
            result = new BuzzNumber(input);
        }
        return result;
    }
}
