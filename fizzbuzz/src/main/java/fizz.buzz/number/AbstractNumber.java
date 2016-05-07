package fizz.buzz.number;

public abstract class AbstractNumber implements Number {
    protected Integer value;

    protected void initializeValueIfValid(Integer initialValue) {
        if (null == initialValue) {
            throw new IllegalArgumentException();
        }
        this.value = initialValue;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public int compareTo(Number o) {
        return value.compareTo(o.getValue());
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractNumber that = (AbstractNumber) o;

        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
