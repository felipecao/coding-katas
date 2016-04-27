package br.felipecao.kata.core.support;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Amount {

    public static final Amount ZERO = new Amount(0);

    private Integer value;

    private Amount(Integer value) {
        this.value = value;
    }

    public static Amount of(Integer value) {
        return new Amount(value);
    }

    public Integer getValue() {
        return value;
    }

    public Amount plus(Amount increment) {
        return new Amount(value + increment.getValue());
    }

    public Amount minus(Amount decrement) {
        return new Amount(value - decrement.getValue());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Amount that = (Amount) other;

        return new EqualsBuilder()
                .append(this.value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.value)
                .toHashCode();
    }
}
