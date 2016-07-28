package com.github.felipecao

class SubsetsFinder {

    private int upperBoundary
    private PositiveIntegers positiveIntegers

    SubsetsFinder(int upperBoundary, int[] positiveIntegers) {
        this.upperBoundary = upperBoundary
        this.positiveIntegers = new PositiveIntegers(positiveIntegers)
    }

    List find() {
        List<Integer> sortedIntegersThatMatter = positiveIntegers
                .removeElementsThatAreGreaterThan(upperBoundary)
                .get()

        if (!sortedIntegersThatMatter || sortedIntegersThatMatter.size() == 1) {
            return [sortedIntegersThatMatter]
        }

        RankedSubSets rankedSubSets = RankedSubSets.buildPossibleSubsetsRankedByDistanceToUpperBoundary(sortedIntegersThatMatter, upperBoundary)

        return rankedSubSets.fetchClosestToUpperBoundary()
    }

}
