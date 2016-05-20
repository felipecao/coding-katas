package fizz.buzz.number.factory;

import fizz.buzz.number.FizzNumber;

public class FizzNumberFactory extends AbstractNumberFactory {

    @Override
    public Integer getDivisor() {
        return 3;
    }

    @Override
    public Class getNumberClass() {
        return FizzNumber.class;
    }
}
