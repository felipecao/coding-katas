package com.github.felipecao

class SubsetsFinder {

    private int upperBoundary
    private PositiveIntegers positiveIntegers

    SubsetsFinder(int upperBoundary, int[] positiveIntegers) {
        this.upperBoundary = upperBoundary
        this.positiveIntegers = new PositiveIntegers(positiveIntegers)
    }

    List find() {
        int[] sortedIntegersThatMatter = positiveIntegers
                .removeElementsThatAreGreaterThan(upperBoundary)
                .reverseSort()
                .getArray()

        if (!sortedIntegersThatMatter || sortedIntegersThatMatter.size() == 1) {
            return [sortedIntegersThatMatter]
        }

        List<RankedSubset> rankedSubsets = buildPossibleSubsetsAndRankByDistanceToUpperBoundary(sortedIntegersThatMatter)
        int smallestDistance = extractSmallestDistance(rankedSubsets)

        return rankedSubsets.findAll {
            it.distanceToUpperBoundary == smallestDistance
        }.collect().numbers
    }

    int extractSmallestDistance(List<RankedSubset> rankedSubsets) {
        return rankedSubsets.distanceToUpperBoundary.min()
    }

    private List<RankedSubset> buildPossibleSubsetsAndRankByDistanceToUpperBoundary(int[] numbers) {

        List<RankedSubset> rankedSubsets = []

        for (int i = 0; i < numbers.size(); i++) {

            def subset = [numbers[i]]

            for (int j = i; j < numbers.size(); j++) {
                if (i != j && (numbers[j] + subset.sum() <= upperBoundary)) {
                    subset << numbers[j]
                }
            }

            rankedSubsets << new RankedSubset(
                    distanceToUpperBoundary: calculateDistanceToUpperBoundary(subset),
                    numbers: subset
            )
        }

        return rankedSubsets
    }

    private int calculateDistanceToUpperBoundary(List<Integer> subset) {
        return upperBoundary - subset.sum()
    }

    private static class RankedSubset {
        int distanceToUpperBoundary
        List numbers
    }

}
