package fizz.buzz.number.factory;

import fizz.buzz.number.*;
import fizz.buzz.number.Number;

/**
 * Created by felipe on 5/20/16.
 */
public class FizzNumberFactory implements NumberFactory, NumberProcessor {

    private NumberFactory successor;

    @Override
    public Number build(Integer input) {
        if (input % 3 == 0) {
            return new FizzNumber(input);
        }

        return successor.build(input);
    }

    @Override
    public void setSuccessor(NumberFactory nextFactory) {
        successor = nextFactory;
    }
}
