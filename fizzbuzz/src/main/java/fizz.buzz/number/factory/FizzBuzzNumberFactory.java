package fizz.buzz.number.factory;

import fizz.buzz.number.FizzBuzzNumber;

public class FizzBuzzNumberFactory extends AbstractNumberFactory {

    @Override
    public Integer getDivisor() {
        return 15;
    }

    @Override
    public Class getNumberClass() {
        return FizzBuzzNumber.class;
    }
}
