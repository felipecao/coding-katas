package fizz.buzz.number.factory;

import fizz.buzz.number.*;
import fizz.buzz.number.Number;

import java.util.LinkedList;

public class NumberFactoryImpl implements NumberFactory {
    private LinkedList<NumberFactory> factories;

    public NumberFactoryImpl() {
        factories = new LinkedList<>();
        factories.addLast(new BuzzNumberFactory());
        factories.addLast(new RegularNumberFactory());
    }

    public Number build(Integer input) {
        if (input % 3 == 0 && input % 5 == 0) {
            return new FizzBuzzNumber(input);
        }

        if (input % 3 == 0) {
            return new FizzNumber(input);
        }

        Number result = null;
        for (NumberFactory factory : factories) {
            result = factory.build(input);
            if (null != result) {
                break;
            }
        }
        return result;
    }
}
