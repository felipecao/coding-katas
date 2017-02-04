package au.com.dius.tennis.rules

import au.com.dius.tennis.Player
import au.com.dius.tennis.Score
import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.PlayersNames.FIRST_PLAYER
import static au.com.dius.tennis.PlayersNames.SECOND_PLAYER
import static au.com.dius.tennis.random.RandomIntegerLessThan50.lessThan

class AdvantageRulesSpec extends Specification {

    @Unroll
    def "isAdvantage returns true when both players have at least 3 points and one of them has 1 more point than the other"() {
        given:
        Score score = new Score(
                new Player(FIRST_PLAYER, player1Points),
                new Player(SECOND_PLAYER, player2Points)
        )

        expect:
        isAdvantage == AdvantageRules.isAdvantage(score)

        where:
        player1Points | player2Points | isAdvantage
        lessThan(3)   | lessThan(3)   | false
        3             | 3             | false
        4             | 3             | true
        3             | 4             | true
        4             | 4             | false
        4             | 5             | true
        5             | 4             | true
        9             | 8             | true
        10            | 8             | false
        12            | 8             | false
    }
}
