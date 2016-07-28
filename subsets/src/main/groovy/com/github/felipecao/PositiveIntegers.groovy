package com.github.felipecao

class PositiveIntegers {
    private List<Integer> numbers

    PositiveIntegers(int[] a) {
        this.numbers = a as List
    }

    private PositiveIntegers(List<Integer> a) {
        this.numbers = a
    }

    PositiveIntegers reverseSort() {
        return new PositiveIntegers(numbers.sort { a, b ->
            b <=> a
        })
    }

    PositiveIntegers removeElementsThatAreGreaterThan(int upperBoundary) {
        return new PositiveIntegers(numbers.findAll {
            it <= upperBoundary
        }.collect())
    }

    int[] get() {
        return numbers as int[]
    }
}
