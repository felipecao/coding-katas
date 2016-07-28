package com.github.felipecao

import spock.lang.Specification

class SubsetsFinderSpec extends Specification {

    SubsetsFinder finder

    def "x = 1 a = [1] ==> a single subset is returned"() {
        given:
        int x = 1
        int[] a = [1]

        and:
        finder = new SubsetsFinder(x, a)

        when:
        List subsets = finder.find()

        then:
        [[1]] == subsets
    }

    def "x = 2, a = [1, 2] ==> [[2]] is returned"() {
        given:
        int x = 2
        int[] a = [1, 2]

        and:
        finder = new SubsetsFinder(x, a)

        when:
        List subsets = finder.find()

        then:
        [[2]] == subsets
    }

    def "x = 3, a = [1, 2] ==> [[2, 1]] is returned"() {
        given:
        int x = 3
        int[] a = [1, 2]

        and:
        finder = new SubsetsFinder(x, a)

        when:
        List subsets = finder.find()

        then:
        [[2, 1]] == subsets
    }

    def "x = 3, a = [1, 1, 2] ==> [2, 1] is returned"() {
        given:
        int x = 3
        int[] a = [1, 1, 2]

        and:
        finder = new SubsetsFinder(x, a)

        when:
        List subsets = finder.find()

        then:
        [[2, 1]] == subsets
    }

    def "x = 3, a = [1, 1, 1] ==> [[1, 1, 1]] is returned"() {
        given:
        int x = 3
        int[] a = [1, 1, 1]

        and:
        finder = new SubsetsFinder(x, a)

        when:
        List subsets = finder.find()

        then:
        [[1, 1, 1]] == subsets
    }

    def "x = 4, a = [8, 3, 2] ==> [[3]] is returned"() {
        given:
        int x = 4
        int[] a = [8, 3, 2]

        and:
        finder = new SubsetsFinder(x, a)

        when:
        List subsets = finder.find()

        then:
        [[3]] == subsets
    }

    def "x = 29, a = [2, 8, 3, 9, 11] ==> [[8, 9, 11]] is returned"() {
        given:
        int x = 29
        int[] a = [2, 8, 3, 9, 11]

        and:
        finder = new SubsetsFinder(x, a)

        when:
        List subsets = finder.find()

        then:
        [[11, 9, 8]] == subsets
    }

}
