package fizz.buzz.number.factory;

import fizz.buzz.number.BuzzNumber;
import fizz.buzz.number.NumberFactory;
import fizz.buzz.number.Number;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractNumberFactory implements NumberProcessor, NumberFactory {

    protected NumberFactory successor;

    @Override
    public void setSuccessor(NumberFactory nextFactory) {
        successor = nextFactory;
    }

    @Override
    public Number build(Integer input) {
        if (input % getDivisor() == 0) {
            return instantiateNumber(input);
        }

        return successor.build(input);
    }

    private Number instantiateNumber(Integer input) {
        try {
            return getNumberClass().getConstructor(Integer.class).newInstance(input);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalArgumentException("Number cannot be instantiated! ", e);
        }
    }

    abstract Integer getDivisor();

    abstract Class<Number> getNumberClass();
}
