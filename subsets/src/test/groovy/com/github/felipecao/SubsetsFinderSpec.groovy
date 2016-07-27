package com.github.felipecao

import spock.lang.Specification

class SubsetsFinderSpec extends Specification {

    SubsetsFinder finder

	def "x < 0 ==> an exception is thrown"(){
        given:
        int x = (randomPositiveInteger() * -1)
        Integer[] a = [1, 2]

        and:
        finder = new SubsetsFinder(upperBoundary: x, positiveIntegers: a)

        when:
        finder.find()

        then:
        thrown(IllegalArgumentException)
    }

	def "x = 0 ==> an exception is thrown"(){
        given:
        int x = 0
        Integer[] a = [1, 2]

        and:
        finder = new SubsetsFinder(upperBoundary: x, positiveIntegers: a)

        when:
        finder.find()

        then:
        thrown(IllegalArgumentException)
    }

	def "x > 0, 'a' is empty ==> an exception is thrown"(){
        given:
        int x = randomPositiveInteger()
        Integer[] a = []

        and:
        finder = new SubsetsFinder(upperBoundary: x, positiveIntegers: a)

        when:
        finder.find()

        then:
        thrown(IllegalArgumentException)
    }

    def "x = 1 a = [1] ==> a single subset is returned"(){
        given:
        int x = 1
        Integer[] a = [1]

        and:
        finder = new SubsetsFinder(upperBoundary: x, positiveIntegers: a)

        when:
        List subsets = finder.find()

        then:
        a as List == subsets
    }

    def "x = 2, a = [1, 2] ==> empty list is returned"(){
        given:
        int x = 2
        Integer[] a = [1, 2]

        when:
        List subsets = finder.find()

        and:
        finder = new SubsetsFinder(upperBoundary: x, positiveIntegers: a)

        then:
        [] == subsets
    }

    def "x = 3, a = [1, 2] ==> a is returned"(){
        given:
        int x = 3
        Integer[] a = [1, 2]

        when:
        List subsets = finder.find()

        and:
        finder = new SubsetsFinder(upperBoundary: x, positiveIntegers: a)

        then:
        a as List == subsets
    }

    def "x = 3, a = [1, 1, 2] ==> [1, 2] is returned"(){
        given:
        int x = 3
        Integer[] a = [1, 1, 2]

        when:
        List subsets = finder.find()

        and:
        finder = new SubsetsFinder(upperBoundary: x, positiveIntegers: a)

        then:
        [1, 2] == subsets
    }

    def "x = 3, a = [1, 1, 1] ==> [1, 1, 1] is returned"(){
        given:
        int x = 3
        Integer[] a = [1, 1, 1]

        when:
        List subsets = finder.find()

        and:
        finder = new SubsetsFinder(upperBoundary: x, positiveIntegers: a)

        then:
        a == subsets
    }

    private int randomPositiveInteger() {
        new Random().nextInt(50)
    }

}
