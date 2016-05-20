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

        return buildNumbersFromZeroToUpperBoundary(upperBoundary);
    }

    private void haltIfUpperBoundaryIsNullOrZero(Integer upperBoundary) {
        if (null == upperBoundary || 0 == upperBoundary) {
            throw new IllegalArgumentException();
        }
    }

    private SortedSet<Number> buildNumbersFromZeroToUpperBoundary(Integer upperBoundary) {
        SortedSet<Number> numbers = new TreeSet<>();

        for (int i=1; i <= upperBoundary; i++) {
            numbers.add(factory.build(i));
        }

        return numbers;
    }
}
