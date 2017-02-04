package au.com.dius.tennis.rules

import au.com.dius.tennis.Player
import au.com.dius.tennis.PlayersNames
import au.com.dius.tennis.Score
import au.com.dius.tennis.rules.VictoryRules
import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.PlayersNames.FIRST_PLAYER
import static au.com.dius.tennis.PlayersNames.SECOND_PLAYER
import static au.com.dius.tennis.random.RandomIntegerLessThan50.lessThan

class VictoryRulesTest extends Specification {

    @Unroll
    def "isVictory returns true when one of the players has scored at least 4 points and has an advantage of two points to the other player"() {
        given:
        Score score = new Score(
                new Player(FIRST_PLAYER, player1Points),
                new Player(PlayersNames.SECOND_PLAYER, player2Points)
        )

        expect:
        isVictory == VictoryRules.isVictory(score)

        where:
        player1Points | player2Points | isVictory
        lessThan(4)   | lessThan(4)   | false
        4             | 3             | false
        5             | 5             | false
        5             | 3             | true
        3             | 5             | true
        7             | 5             | true
    }
}
