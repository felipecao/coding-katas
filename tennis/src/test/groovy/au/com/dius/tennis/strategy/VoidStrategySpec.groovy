package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players
import au.com.dius.tennis.ScoreDisplayStrategy
import au.com.dius.tennis.random.RandomString16CharsLong
import spock.lang.Specification

import static org.apache.commons.lang3.StringUtils.EMPTY

class VoidStrategySpec extends Specification {

    private ScoreDisplayStrategy strategy

    def setup() {
        strategy = new VoidStrategy(new Players(RandomString16CharsLong.get(), RandomString16CharsLong.get()))
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
