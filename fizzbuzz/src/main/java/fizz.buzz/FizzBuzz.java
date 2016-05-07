package fizz.buzz;

import fizz.buzz.number.NumberFactory;
import fizz.buzz.number.Numbers;
import fizz.buzz.number.Number;

import java.util.SortedSet;

public class FizzBuzz {

    private Numbers numbers;

    public FizzBuzz() {
        NumberFactory factory = new NumberFactory();
        numbers = new Numbers(factory);
    }

    public String fizzBuzz(Integer upperBoundary) {

        String result = "";
        SortedSet<Number> allNumbers = numbers.fetch(upperBoundary);

        for (Number number: allNumbers) {
            result += number.toString() + " ";
        }

        return result.trim();
    }
}