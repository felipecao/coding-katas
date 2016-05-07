package fizz.buzz.number;

public class RegularNumber extends AbstractNumber {

    public RegularNumber(Integer value) {
        if (null == value) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }
}
