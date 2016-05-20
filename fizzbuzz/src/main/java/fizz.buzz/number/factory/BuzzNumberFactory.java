package fizz.buzz.number.factory;

import fizz.buzz.number.*;
import fizz.buzz.number.Number;

/**
 * Created by felipe on 5/20/16.
 */
public class BuzzNumberFactory implements NumberFactory, NumberProcessor {

    private NumberFactory successor;

    @Override
    public Number build(Integer input) {
        if (input % 5 == 0) {
            return new BuzzNumber(input);
        }

        return successor.build(input);
    }

    @Override
    public void setSuccessor(NumberFactory nextFactory) {
        successor = nextFactory;
    }
}
