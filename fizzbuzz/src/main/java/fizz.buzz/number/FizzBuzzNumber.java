package fizz.buzz.number;

public class FizzBuzzNumber extends AbstractNumber {

    public FizzBuzzNumber(Integer value) {
        initializeValueIfValid(value);
    }

    @Override
    public String toString() {
        return "FizzBuzz";
    }
}
