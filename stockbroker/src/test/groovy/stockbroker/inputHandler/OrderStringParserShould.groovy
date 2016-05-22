package stockbroker.inputHandler

import spock.lang.Specification

class OrderStringParserShould extends Specification {

    OrderStringParser parser

    def setup() {
        parser = new OrderStringParser()
    }

    def "return original input and say status failure because input is null"() {
        given:
        String input = null

        when:
        def result = parser.parse(input)

        then:
        [status: "failure"] == result
    }

    def "return original input and say status failure because input is empty"() {
        given:
        String input = ""

        when:
        def result = parser.parse(input)

        then:
        [status: "failure"] == result
    }

    def "return original input and say status failure because input is empty string"() {
        given:
        String input = " "

        when:
        def result = parser.parse(input)

        then:
        [status: "failure"] == result
    }

    def "return original input and say status failure due to invalid price"() {
        given:
        String input = "CDEF 50 70 B"

        when:
        def result = parser.parse(input)

        then:
        [status: "failure"] == result
    }

    def "return original input and say status failure due to invalid type"() {
        given:
        String input = "CDEF 50 70.0 E"

        when:
        def result = parser.parse(input)

        then:
        [status: "failure"] == result
    }

    def "return original input and say status failure due to type with more than one char"() {
        given:
        String input = "CDEF 50 70.0 E "

        when:
        def result = parser.parse(input)

        then:
        [status: "failure"] == result
    }

    def "return original input and say status failure due to absent type"() {
        given:
        String input = "CDEF 50 70.0 "

        when:
        def result = parser.parse(input)

        then:
        [status: "failure"] == result
    }

    def "return original input and say status failure due to floating quantity"() {
        given:
        String input = "CDEF 50.0 70.0 B"

        when:
        def result = parser.parse(input)

        then:
        [status: "failure"] == result
    }

    def "return original input and say status failure due to absent quote"() {
        given:
        String input = " 50 70.0 B"

        when:
        def result = parser.parse(input)

        then:
        [status: "failure"] == result
    }

    def "say status success and return an order amount of 3500"() {
        given:
        String input = "CDEF 50 70.0 B"

        when:
        def result = parser.parse(input)

        then:
        [status: "success", totalOrderAmount: (50 * 70.0) as Integer] == result
    }

    def "say status success and return an order amount of 200"() {
        given:
        String input = "CDEF 20 10.0 B"

        when:
        def result = parser.parse(input)

        then:
        [status: "success", totalOrderAmount: (20 * 10.0) as Integer] == result
    }

    def "say status success for quote with dot and return an order amount of 200"() {
        given:
        String input = "CLH15.NYM 50 56.32 B"

        when:
        def result = parser.parse(input)

        then:
        [status: "success", totalOrderAmount: (50 * 56.32) as Integer] == result
    }
}
