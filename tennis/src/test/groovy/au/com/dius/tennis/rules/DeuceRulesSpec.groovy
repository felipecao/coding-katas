package au.com.dius.tennis.rules

import au.com.dius.tennis.Player
import au.com.dius.tennis.Score
import au.com.dius.tennis.random.RandomString16CharsLong
import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan
import static au.com.dius.tennis.random.RandomIntegerLessThan50.lessThan

class DeuceRulesSpec extends Specification {

    @Unroll
    def "isDeuce returns true when both players have the same number of points and have scored at least 3 points"() {
        given:
        Score score = new Score(
                new Player(RandomString16CharsLong.get(), player1Points),
                new Player(RandomString16CharsLong.get(), player2Points)
        )

        expect:
        isDeuce == DeuceRules.isDeuce(score)

        where:
        player1Points  | player2Points  | isDeuce
        lessThan(3)    | lessThan(3)    | false
        3              | 3              | true
        greaterThan(3) | 3              | false
        3              | greaterThan(3) | false
        4              | 4              | true
        5              | 5              | true
    }
}
