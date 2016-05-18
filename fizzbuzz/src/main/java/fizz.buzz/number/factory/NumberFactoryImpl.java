package fizz.buzz.number.factory;

import fizz.buzz.number.*;
import fizz.buzz.number.Number;

public class NumberFactoryImpl implements NumberFactory {
    private final BuzzNumberFactory buzzNumberFactory = new BuzzNumberFactory();

    public Number build(Integer input) {

        if (input % 3 == 0 && input % 5 == 0) {
            return new FizzBuzzNumber(input);
        }

        if (input % 3 == 0) {
            return new FizzNumber(input);
        }

        Number result = buzzNumberFactory.build(input);
        if (null != result) {
            return result;
        }

        return new RegularNumber(input);
    }
}
