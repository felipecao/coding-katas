package fizz.buzz.number.factory;

import fizz.buzz.number.BuzzNumber;
import fizz.buzz.number.Number;
import fizz.buzz.number.NumberFactory;

class BuzzNumberFactory implements NumberFactory{

    /**
     * @param input integer to build the number from
     * @return null if integer input is not supported
     */
    public Number build(Integer input) {
        Number result = null;
        if (input % 5 == 0) {
            result = new BuzzNumber(input);
        }
        return result;
    }
}