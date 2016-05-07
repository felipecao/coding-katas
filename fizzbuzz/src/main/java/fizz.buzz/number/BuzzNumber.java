package fizz.buzz.number;

public class BuzzNumber extends AbstractNumber {
    public BuzzNumber(Integer value) {
        initializeValueIfValid(value);
    }

    @Override
    public String toString() {
        return "Buzz";
    }
}
