package fizz.buzz.number.factory;

import fizz.buzz.number.BuzzNumber;

public class BuzzNumberFactory extends AbstractNumberFactory {

    @Override
    public Integer getDivisor() {
        return 5;
    }

    @Override
    public Class getNumberClass() {
        return BuzzNumber.class;
    }
}
