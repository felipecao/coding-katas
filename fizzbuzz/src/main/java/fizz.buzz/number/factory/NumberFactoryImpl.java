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

        if (input % 5 == 0) {
            return new BuzzNumber(input);
        }

        return new RegularNumber(input);
    }
}
