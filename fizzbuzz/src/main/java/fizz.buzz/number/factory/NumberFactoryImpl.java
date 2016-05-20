package fizz.buzz.number.factory;

import fizz.buzz.number.Number;
import fizz.buzz.number.NumberFactory;

public class NumberFactoryImpl implements NumberFactory {

    private FizzBuzzNumberFactory numberFactory;

    public NumberFactoryImpl() {
        RegularNumberFactory regularFactory = new RegularNumberFactory();
        BuzzNumberFactory buzzFactory = new BuzzNumberFactory();
        FizzNumberFactory fizzFactory = new FizzNumberFactory();

        numberFactory = new FizzBuzzNumberFactory();

        buzzFactory.setSuccessor(regularFactory);
        fizzFactory.setSuccessor(buzzFactory);
        numberFactory.setSuccessor(fizzFactory);
    }

    public Number build(Integer input) {
        return numberFactory.build(input);
    }
}
