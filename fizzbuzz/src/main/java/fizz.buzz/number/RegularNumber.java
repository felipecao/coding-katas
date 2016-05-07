package fizz.buzz.number;

public class RegularNumber extends AbstractNumber {

    public RegularNumber(Integer value) {
        initializeValueIfValid(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegularNumber that = (RegularNumber) o;

        return value.equals(that.value);
    }
}
