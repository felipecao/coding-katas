package fizz.buzz.number;

import fizz.buzz.Numbers;

import java.util.SortedSet;
import java.util.TreeSet;

public class NumbersImpl implements Numbers {

    private NumberFactory factory;

    public NumbersImpl(NumberFactory factory) {
        this.factory = factory;
    }

    public SortedSet<Number> fetch(Integer upperBoundary) {
        haltIfUpperBoundaryIsNullOrZero(upperBoundary);

        SortedSet<Number> numbers = new TreeSet<>();

        for (int i=1; i <= upperBoundary; i++) {
            numbers.add(factory.build(i));
        }

        return numbers;
    }

    private void haltIfUpperBoundaryIsNullOrZero(Integer upperBoundary) {
        if (null == upperBoundary || 0 == upperBoundary) {
            throw new IllegalArgumentException();
        }
    }
}
