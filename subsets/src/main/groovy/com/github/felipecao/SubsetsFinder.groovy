package com.github.felipecao

class SubsetsFinder {

    private int upperBoundary
    private int[] positiveIntegers

    List find() {
        makeSureInputsAreValid()

        def subsets = []
        List<Integer> sortedIntegers = reverseSort(positiveIntegers)

        sortedIntegers = removeElementsThatAreGreaterThanX(sortedIntegers, upperBoundary)

        sortedIntegers.each {
            // subsets << combinationsBasedOnX(positiveIntegers, upperBoundary)
        }

        return subsets
    }

    private void makeSureInputsAreValid() {
        failIfUpperBoundaryIsNonPositive()
        failIfPositiveIntegersAreEmpty()
    }

    private void failIfUpperBoundaryIsNonPositive() {
        if (upperBoundary < 1) {
            throw new IllegalArgumentException()
        }
    }

    private void failIfPositiveIntegersAreEmpty() {
        if (!positiveIntegers) {
            throw new IllegalArgumentException()
        }
    }

    private List<Integer> reverseSort(int[] arr) {
        return (arr as List).sort { a, b ->
            b <=> a
        }
    }

    private List removeElementsThatAreGreaterThanX(List<Integer> a, int x) {
        return a.findAll {
            it <= x
        }.collect()
    }
}
