package au.com.dius.tennis.rules

import au.com.dius.tennis.Player
import au.com.dius.tennis.Score
import au.com.dius.tennis.random.RandomString16CharsLong
import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan

class RegularScoreRulesSpec extends Specification {

    @Unroll
    def "isRegularScore returns true if both players are below 3 points"() {
        given:
        Score score = new Score(
                new Player(RandomString16CharsLong.get(), player1Points),
                new Player(RandomString16CharsLong.get(), player2Points)
        )

        expect:
        isRegularScore == RegularScoreRules.isRegularScore(score)

        where:
        player1Points  | player2Points  | isRegularScore
        0              | 0              | true
        1              | 0              | true
        2              | 0              | true
        3              | 0              | true
        0              | 1              | true
        0              | 2              | true
        0              | 3              | true
        1              | 1              | true
        2              | 2              | true
        2              | 1              | true
        1              | 2              | true
        3              | 1              | true
        1              | 3              | true
        3              | 2              | true
        2              | 3              | true
        3              | 3              | false
        greaterThan(3) | greaterThan(3) | false
    }
}
