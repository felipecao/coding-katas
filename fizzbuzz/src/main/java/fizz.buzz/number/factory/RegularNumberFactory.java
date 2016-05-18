package fizz.buzz.number.factory;

import fizz.buzz.number.Number;
import fizz.buzz.number.NumberFactory;
import fizz.buzz.number.RegularNumber;

class RegularNumberFactory implements NumberFactory{
    public Number build(Integer input) {
        return new RegularNumber(input);
    }
}