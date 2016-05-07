package fizz.buzz;

public class FizzBuzz {
    public FizzBuzz() {
    }

    public String fizzBuzz(Integer upperBoundary) {

        if (isIllegalArgument(upperBoundary)) {
            throw new IllegalArgumentException();
        }

        String result = "1";

        for (int i = 2; i <= upperBoundary; i++) {
            if ((0 == (i % 3)) && (0 == (i % 5))) {
                result += " FizzBuzz";
                continue;
            }
            if (0 == (i % 3)) {
                result += " Fizz";
                continue;
            }
            if (0 == (i % 5)) {
                result += " Buzz";
                continue;
            }
            result += " " + i;
        }

        return result;
    }

    private boolean isIllegalArgument(Integer upperBoundary) {
        return null == upperBoundary || 0 == upperBoundary;
    }
}