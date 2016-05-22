package stockbroker.useCase

import spock.lang.Specification

class SummarizeStocksShould extends Specification {

    SummarizeStocks useCase

    def setup() {
        useCase = new SummarizeStocks()
    }

    def "sum and round 4 bought stocks"() {
        given:
        String input = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B"
        String expectedSummary = "Buy: 29499 Sell: 0"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "sum and round 3 bought and 1 sold stocks"() {
        given:
        String input = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 S"
        String expectedSummary = "Buy: 17897 Sell: 6295"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "sum and round 2 bought and 2 sold stocks"() {
        given:
        String input = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 S, OGG 20 580.1 S"
        String expectedSummary = "Buy: 6274 Sell: 23225"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "sum and round 1 bought and 3 sold stocks"() {
        given:
        String input = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 S, OWW 1000 11.623 S, OGG 20 580.1 S"
        String expectedSummary = "Buy: 3458 Sell: 26041"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "sum and round 0 bought and 4 sold stocks"() {
        given:
        String input = "ZNGA 1300 2.66 S, CLH15.NYM 50 56.32 S, OWW 1000 11.623 S, OGG 20 580.1 S"
        String expectedSummary = "Buy: 0 Sell: 29499"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "sum and round 1 bought, 2 sold and 1 invalid stocks"() {
        given:
        String input = "ZNGA 1300 2.66, CLH15.NYM 50 56.32 B, OWW 1000 11.623 S, OGG 20 580.1 S"
        String expectedSummary = "Buy: 2816 Sell: 23225; Badly formed 1: ZNGA 1300 2.66"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "sum and round 1 bought, 1 sold and 2 invalid stocks"() {
        given:
        String input = "ZNGA 1300 2.66 B, CLH15.NYM 50 56 B, OWW 1000 11 S, OGG 20 580.1 S"
        String expectedSummary = "Buy: 3458 Sell: 11602; Badly formed 2: CLH15.NYM 50 56 B; OWW 1000 11 S"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "report 4 invalid stocks"() {
        given:
        String input = "ZNGA 1300 2 B, CLH15.NYM 50 56 B, OWW 1000 11 S, OGG 20 580 S"
        String expectedSummary = "Buy: 0 Sell: 0; Badly formed 4: ZNGA 1300 2 B; CLH15.NYM 50 56 B; OWW 1000 11 S; OGG 20 580 S"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "report 3 invalid stocks"() {
        given:
        String input = "ZNGA 1300 2 B, CLH15.NYM 50 56 B, OWW 1000 11 S"
        String expectedSummary = "Buy: 0 Sell: 0; Badly formed 3: ZNGA 1300 2 B; CLH15.NYM 50 56 B; OWW 1000 11 S"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "report 2 invalid stocks"() {
        given:
        String input = "ZNGA 1300 2 B, CLH15.NYM 50 56 B"
        String expectedSummary = "Buy: 0 Sell: 0; Badly formed 2: ZNGA 1300 2 B; CLH15.NYM 50 56 B"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "report 1 invalid stock"() {
        given:
        String input = "ZNGA 1300 2 B"
        String expectedSummary = "Buy: 0 Sell: 0; Badly formed 1: ZNGA 1300 2 B"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "report no stocks"() {
        given:
        String input = ""
        String expectedSummary = "Buy: 0 Sell: 0"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "report no stocks for empty input"() {
        given:
        String input = "      "
        String expectedSummary = "Buy: 0 Sell: 0"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

    def "report no stocks for null input"() {
        given:
        String input = null
        String expectedSummary = "Buy: 0 Sell: 0"

        when:
        String output = useCase.execute(input)

        then:
        output == expectedSummary
    }

}
