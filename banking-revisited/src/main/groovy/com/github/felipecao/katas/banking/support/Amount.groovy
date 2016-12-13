package com.github.felipecao.katas.banking.support

class Amount {

    private final int importance

    private Amount(int importance) {
        this.importance = importance
    }

    public static Amount of(int importance) {
        new Amount(importance)
    }

    public static Amount negativeOf(Amount amount) {
        of(-1 * amount.importance)
    }

    Amount plus(Amount amount) {
        of(importance + amount.importance)
    }

    Amount minus(Amount amount) {
        of(importance - amount.importance)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Amount amount = (Amount) o

        if (importance != amount.importance) return false

        return true
    }

    int hashCode() {
        return importance
    }


    @Override
    public String toString() {
        return importance.toString()
    }
}
