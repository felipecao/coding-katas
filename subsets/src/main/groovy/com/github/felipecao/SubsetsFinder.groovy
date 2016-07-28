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
                .get()

        if (!sortedIntegersThatMatter || sortedIntegersThatMatter.size() == 1) {
            return [sortedIntegersThatMatter]
        }

        List<RankedSubset> rankedSubsets = buildPossibleSubsetsAndRankByDistanceToUpperBoundary(sortedIntegersThatMatter)

        return rankedSubsetsClosestToUpperBoundary(rankedSubsets)
    }

    private Collection<List> rankedSubsetsClosestToUpperBoundary(List<RankedSubset> rankedSubsets) {
        int smallestDistance = smallestDistanceToUpperBoundary(rankedSubsets)
        
        rankedSubsets.findAll {
            it.distanceToUpperBoundary == smallestDistance
        }.collect().numbers
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

            rankedSubsets << new RankedSubset(subset, upperBoundary)
        }

        return rankedSubsets
    }

    private int smallestDistanceToUpperBoundary(List<RankedSubset> rankedSubsets) {
        return rankedSubsets.distanceToUpperBoundary.min()
    }

}
