package com.github.felipecao

class PositiveIntegers {
    private List<Integer> numbers

    PositiveIntegers(int[] a) {
        this.numbers = a as List
    }

    private PositiveIntegers(List<Integer> a) {
        this.numbers = a
    }

    PositiveIntegers removeElementsThatAreGreaterThan(int upperBoundary) {
        return new PositiveIntegers(numbers.findAll {
            it <= upperBoundary
        }.collect())
    }

    List<Integer> get() {
        return new ArrayList<>(numbers)
    }
}
