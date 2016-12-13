package com.github.felipecao.katas.banking.support

import spock.lang.Specification

class AmountSpec extends Specification {

    def "two amounts of same importance are equal"() {
        given:
        Amount first = Amount.of(100)
        Amount second = Amount.of(100)

        expect:
        first == second
    }

    def "two amounts of different importances are not equal"() {
        given:
        Amount first = Amount.of(100)
        Amount second = Amount.of(101)

        expect:
        first != second
    }

    def "incrementing an amount returns a new object"() {
        given:
        Amount first = Amount.of(100)

        when:
        Amount second = first.plus(Amount.of(1))

        then:
        Amount.of(101) == second
        first != second
        !first.is(second)
    }

    def "decrementing an amount returns a new object"() {
        given:
        Amount first = Amount.of(100)

        when:
        Amount second = first.minus(Amount.of(1))

        then:
        Amount.of(99) == second
        first != second
        !first.is(second)
    }

    def "negative amounts are equal"() {
        given:
        Amount first = Amount.of(-100)

        when:
        Amount second = Amount.negativeOf(Amount.of(100))

        then:
        first == second
        !first.is(second)
    }

}
