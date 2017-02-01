package au.com.dius.tennis

import spock.lang.Specification
import spock.lang.Unroll

class AcceptanceTests extends Specification {

    private Game game

    private static final String FIRST_PLAYER = "player 1"
    private static final String SECOND_PLAYER = "player 2"

    def setup() {
        game = new Game(FIRST_PLAYER, SECOND_PLAYER)
    }

    @Unroll
    def "When the first player has scored #totalPointsWonByPlayer1 points and the second player has scored #totalPointsWonByPlayer2 the score is #score"() {
        given:
        totalPointsWonByPlayer1.times {
            game.pointWonBy(FIRST_PLAYER)
        }

        and:
        totalPointsWonByPlayer2.times {
            game.pointWonBy(SECOND_PLAYER)
        }

        expect:
        score == game.score()

        where:
        totalPointsWonByPlayer1 | totalPointsWonByPlayer2   | score
        0                       | 0                         | "0-0"
        1                       | 0                         | "15-0"
        2                       | 0                         | "30-0"
        3                       | 0                         | "40-0"
        0                       | 1                         | "0-15"
        0                       | 2                         | "0-30"
        0                       | 3                         | "0-40"
        1                       | 1                         | "15-15"
        2                       | 2                         | "30-30"
        2                       | 1                         | "30-15"
        1                       | 2                         | "15-30"
        3                       | 1                         | "40-15"
        1                       | 3                         | "15-40"
        3                       | 2                         | "40-30"
        2                       | 3                         | "30-40"
        3                       | 3                         | "Deuce"
        4                       | 4                         | "Deuce"
        4                       | 3                         | "Advantage $FIRST_PLAYER"
        3                       | 4                         | "Advantage $SECOND_PLAYER"
    }

}
