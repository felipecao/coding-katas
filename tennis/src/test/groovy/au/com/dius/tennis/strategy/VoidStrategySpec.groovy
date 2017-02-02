package au.com.dius.tennis.strategy

import au.com.dius.tennis.random.RandomString16CharsLong
import spock.lang.Specification

import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan

class VoidStrategySpec extends Specification {

    private ScoreCalculationStrategy strategy

    def setup() {
        strategy = new VoidStrategy([
                (RandomString16CharsLong.get()): greaterThan(0),
                (RandomString16CharsLong.get()): greaterThan(0)
        ])
    }

    def "VoidStrategy should always display a blank string as score"() {
        expect:
        AbstractStrategy.BLANK == strategy.displayScore()
    }

    def "VoidStrategy is always applicable, no matter what score"() {
        expect:
        strategy.isApplicableToScore()
    }

}
