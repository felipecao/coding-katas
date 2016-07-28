package com.github.felipecao

class RankedSubSet {
    private int distanceToUpperBoundary
    private List numbers
    private int upperBoundary

    RankedSubSet(List numbers, int upperBoundary) {
        this.distanceToUpperBoundary = calculateDistanceToUpperBoundary(numbers)
        this.numbers = numbers
        this.upperBoundary = upperBoundary
    }

    private int calculateDistanceToUpperBoundary(List<Integer> subset) {
        return upperBoundary - subset.sum()
    }
}
