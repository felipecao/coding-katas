package fizz.buzz.number;

public class FizzNumber extends AbstractNumber {
    public FizzNumber(Integer value) {
        initializeValueIfValid(value);
    }

    @Override
    public String toString() {
        return "Fizz";
    }
}
