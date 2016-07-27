package com.github.felipecao

class SubsetsFinder {

    private int upperBoundary
    private int[] positiveIntegers

    List find() {
        makeSureInputsAreValid()

        def subsets = []

        positiveIntegers = reverseSort(positiveIntegers)
        positiveIntegers = removeElementsThatAreGreaterThanX(positiveIntegers, upperBoundary)

        positiveIntegers.each {
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

    private int[] reverseSort(int[] a) {
        return a
    }

    private int[] removeElementsThatAreGreaterThanX(int[] a, int x) {
        return a
    }
}
