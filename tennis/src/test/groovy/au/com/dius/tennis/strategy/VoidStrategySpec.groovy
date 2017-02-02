package au.com.dius.tennis.strategy

import au.com.dius.tennis.ScoreDisplayStrategy
import au.com.dius.tennis.random.RandomString16CharsLong
import static org.apache.commons.lang3.StringUtils.EMPTY
import spock.lang.Specification

import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan

class VoidStrategySpec extends Specification {

    private ScoreDisplayStrategy strategy

    def setup() {
        strategy = new VoidStrategy([
                (RandomString16CharsLong.get()): greaterThan(0),
                (RandomString16CharsLong.get()): greaterThan(0)
        ])
    }

    def "VoidStrategy should always display a blank string as score"() {
        expect:
        EMPTY == strategy.displayScore()
    }

    def "VoidStrategy is always applicable, no matter what score"() {
        expect:
        strategy.isApplicableToScore()
    }

}
