package au.com.dius.tennis

import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.PlayersNames.FIRST_PLAYER
import static au.com.dius.tennis.PlayersNames.SECOND_PLAYER

class AcceptanceTests extends Specification {

    public static final String DEUCE = "Deuce"
    private Game game

    def setup() {
        game = new Game(FIRST_PLAYER, SECOND_PLAYER)
    }

    @Unroll
    def "When the first player has scored #totalPointsWonByPlayer1 points in sequence and the second player has scored #totalPointsWonByPlayer2 in sequence the score is #score"() {
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
        3                       | 3                         | DEUCE
        4                       | 0                         | playerWins(FIRST_PLAYER)
        0                       | 4                         | playerWins(SECOND_PLAYER)
    }

    def "When players exchange points along the game, the winner is the first one to obtain a two points difference, regardless if the players continue to play"() {
        given: "15-15"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "30-30"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and:
        DEUCE
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "Advantage player 1"
        game.pointWonBy(FIRST_PLAYER)

        and:
        DEUCE
        game.pointWonBy(SECOND_PLAYER)

        and: "Advantage player 1"
        game.pointWonBy(FIRST_PLAYER)

        and:
        DEUCE
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
        playerWins(FIRST_PLAYER) == game.score()
    }

    def "When players exchange points until a Deuce, the score is 'Deuce'"() {
        given: "15-15"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "30-30"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and:
        DEUCE
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        expect:
        DEUCE == game.score()
    }

    def "When players exchange points until an advantage to player 1, the score is 'Advantage player 1'"() {
        given: "15-15"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "30-30"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and:
        DEUCE
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "Advantage player 1"
        game.pointWonBy(FIRST_PLAYER)

        expect:
        playerHasAdvantage(FIRST_PLAYER) == game.score()
    }

    def "When players exchange points until an advantage to player 2, the score is 'Advantage player 2'"() {
        given: "15-15"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "30-30"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and:
        DEUCE
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "Advantage player 1"
        game.pointWonBy(SECOND_PLAYER)

        expect:
        playerHasAdvantage(SECOND_PLAYER) == game.score()
    }

    def "Player 2 loses by only scoring 15"() {
        given: "15-15"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "30-15"
        game.pointWonBy(FIRST_PLAYER)

        and: "40-15"
        game.pointWonBy(FIRST_PLAYER)

        and: "Player 1 wins"
        game.pointWonBy(FIRST_PLAYER)

        expect:
        playerWins(FIRST_PLAYER) == game.score()
    }

    def "Player 1 loses by only scoring 15"() {
        given: "15-15"
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        and: "30-15"
        game.pointWonBy(SECOND_PLAYER)

        and: "40-15"
        game.pointWonBy(SECOND_PLAYER)

        and: "Player 1 wins"
        game.pointWonBy(SECOND_PLAYER)

        expect:
        playerWins(SECOND_PLAYER) == game.score()
    }

    private String playerWins(String playerName) {
        "$playerName wins"
    }

    private String playerHasAdvantage(String playerName) {
        "Advantage $playerName"
    }

}
