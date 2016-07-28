package com.github.felipecao

class SubsetsFinder {

    private int upperBoundary
    private PositiveIntegers positiveIntegers

    SubsetsFinder(int upperBoundary, int[] positiveIntegers) {
        this.upperBoundary = upperBoundary
        this.positiveIntegers = new PositiveIntegers(positiveIntegers)
    }

    List find() {
        List<Integer> numbersThatMatter = positiveIntegers
                .removeElementsThatAreGreaterThan(upperBoundary)
                .get()

        if (!numbersThatMatter || numbersThatMatter.size() == 1) {
            return [numbersThatMatter]
        }

        RankedSubSets rankedSubSets = RankedSubSets.buildPossibleSubsetsRankedByDistanceToUpperBoundary(numbersThatMatter, upperBoundary)

        return rankedSubSets.fetchClosestToUpperBoundary()
    }

}
