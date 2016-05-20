package fizz.buzz.number.factory;

import fizz.buzz.number.*;
import fizz.buzz.number.Number;

public class RegularNumberFactory implements NumberFactory {

    @Override
    public Number build(Integer input) {
        return new RegularNumber(input);
    }
}
