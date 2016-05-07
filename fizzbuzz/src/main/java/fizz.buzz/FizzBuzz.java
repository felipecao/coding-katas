package fizz.buzz;

import fizz.buzz.number.Number;
import fizz.buzz.number.NumberFactory;
import fizz.buzz.number.Numbers;

import java.util.SortedSet;

public class FizzBuzz {

    private static final String SPACE = " ";
    private Numbers numbers;

    public FizzBuzz() {
        NumberFactory factory = new NumberFactory();
        numbers = new Numbers(factory);
    }

    public String fizzBuzz(Integer upperBoundary) {

        SortedSet<Number> allNumbers = numbers.fetch(upperBoundary);

        return allNumbers.stream()
                .map(Number::toString)
                .reduce((n, u) -> n.toString() + SPACE + u.toString())
                .get();
    }
}