package fizz.buzz.number.factory;

import fizz.buzz.number.Number;
import fizz.buzz.number.NumberFactory;

public class NumberFactoryImpl implements NumberFactory {

    private FizzBuzzNumberFactory numberFactory;

    public NumberFactoryImpl() {
        chainFactories();
    }

    private void chainFactories() {
        FizzNumberFactory fizzFactory = new FizzNumberFactory();
        BuzzNumberFactory buzzFactory = new BuzzNumberFactory();
        RegularNumberFactory regularFactory = new RegularNumberFactory();

        numberFactory = new FizzBuzzNumberFactory();
        numberFactory.setSuccessor(fizzFactory);
        fizzFactory.setSuccessor(buzzFactory);
        buzzFactory.setSuccessor(regularFactory);
    }

    public Number build(Integer input) {
        return numberFactory.build(input);
    }
}
