package fizz.buzz.number;

import java.util.SortedSet;
import java.util.TreeSet;

public class Numbers {
    public SortedSet<Number> fetch(Integer upperBoundary) {
        haltIfUpperBoundaryIsNullOrZero(upperBoundary);

        SortedSet<Number> numbers = new TreeSet<Number>();

        for (int i=1; i <= upperBoundary; i++) {
            numbers.add(new RegularNumber(i));
        }

        return numbers;
    }

    private void haltIfUpperBoundaryIsNullOrZero(Integer upperBoundary) {
        if (null == upperBoundary || 0 == upperBoundary) {
            throw new IllegalArgumentException();
        }
    }
}
