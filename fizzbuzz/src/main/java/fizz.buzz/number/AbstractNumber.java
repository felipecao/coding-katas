package fizz.buzz.number;

public abstract class AbstractNumber implements Number {
    protected Integer value;

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(Number o) {
        return value.compareTo(o.getValue());
    }
}
