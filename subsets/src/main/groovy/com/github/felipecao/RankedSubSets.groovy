package com.github.felipecao

class RankedSubSets {

    private List<RankedSubSet> rankedSubsets = []
    private int upperBoundary

    private RankedSubSets() {

    }

    static RankedSubSets buildPossibleSubsetsRankedByDistanceToUpperBoundary(int[] numbers, int upperBoundary) {

        RankedSubSets instance = new RankedSubSets()

        instance.upperBoundary = upperBoundary

        for (int i = 0; i < numbers.size(); i++) {

            def subset = [numbers[i]]

            for (int j = i; j < numbers.size(); j++) {
                if (i != j && (numbers[j] + subset.sum() <= upperBoundary)) {
                    subset << numbers[j]
                }
            }

            instance.rankedSubsets << new RankedSubSet(subset, upperBoundary)
        }

        return instance
    }

    List fetchClosestToUpperBoundary() {
        int smallestDistance = smallestDistanceToUpperBoundary(rankedSubsets)

        rankedSubsets.findAll {
            it.distanceToUpperBoundary == smallestDistance
        }.collect().numbers
    }

    private int smallestDistanceToUpperBoundary(List<RankedSubSet> rankedSubsets) {
        return rankedSubsets.distanceToUpperBoundary.min()
    }
}
