package fizz.buzz.number.factory;

import fizz.buzz.number.*;
import fizz.buzz.number.Number;

public class FizzBuzzNumberFactory implements NumberFactory, NumberProcessor {

    private NumberFactory successor;

    @Override
    public Number build(Integer input) {
        if (input % 3 == 0 && input % 5 == 0) {
            return new FizzBuzzNumber(input);
        }

        return successor.build(input);
    }

    @Override
    public void setSuccessor(NumberFactory nextFactory) {
        successor = nextFactory;
    }
}
