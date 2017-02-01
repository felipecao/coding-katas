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
    def "When the first player has scored #totalPointsWonByPlayer1 points in sequence and the second player has scored #totalPointsWonByPlayer2 the score in sequence is #score"() {
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
        3                       | 4                         | "Advantage $SECOND_PLAYER"
        5                       | 3                         | "$FIRST_PLAYER wins"
        3                       | 5                         | "$SECOND_PLAYER wins"
        9                       | 7                         | "$FIRST_PLAYER wins"
    }

    def "When players exchange points along the game, the winner is the first one to obtain a two points difference, regardless if the players continue to play"() {
        given: "15-15"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "30-30"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "Deuce"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "Advantage player 1"
        game.pointWonBy(FIRST_PLAYER)

        and: "Deuce"
        game.pointWonBy(SECOND_PLAYER)

        and: "Advantage player 1"
        game.pointWonBy(FIRST_PLAYER)

        and: "Deuce"
        game.pointWonBy(SECOND_PLAYER)

        and: "Advantage player 1"
        game.pointWonBy(FIRST_PLAYER)

        and: "player 1 wins"
        game.pointWonBy(FIRST_PLAYER)

        and: "player 2 continues to play for a couple of rounds"
        game.pointWonBy(SECOND_PLAYER)
        game.pointWonBy(SECOND_PLAYER)
        game.pointWonBy(SECOND_PLAYER)
        game.pointWonBy(SECOND_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        expect: "player 1 should continue to be the winner, even though player 2 continued to play"
        "$FIRST_PLAYER wins" == game.score()
    }

    def "When players exchange points until a Deuce, the score is 'Deuce'"() {
        given: "15-15"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "30-30"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "Deuce"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        expect:
        "Deuce" == game.score()
    }

    def "When players exchange points until an advantage, the score is 'Advantage player N'"() {
        given: "15-15"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "30-30"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "Deuce"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "Advantage player 1"
        game.pointWonBy(FIRST_PLAYER)

        expect:
        "Advantage $FIRST_PLAYER" == game.score()
    }

}
