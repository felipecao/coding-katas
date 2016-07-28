package com.github.felipecao

class RankedSubSets {

    private List<RankedSubSet> rankedSubsets = []

    private RankedSubSets() {

    }

    static RankedSubSets buildPossibleSubsetsRankedByDistanceToUpperBoundary(List<Integer> numbers, int upperBoundary) {

        RankedSubSets instance = new RankedSubSets()

        numbers.subsequences().findAll {
            it.sum() <= upperBoundary
        }.each {
            instance.rankedSubsets << new RankedSubSet(it, upperBoundary)
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
