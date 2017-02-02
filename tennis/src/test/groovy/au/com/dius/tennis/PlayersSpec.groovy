package au.com.dius.tennis

import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.PlayersNames.FIRST_PLAYER
import static au.com.dius.tennis.PlayersNames.SECOND_PLAYER
import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan
import static au.com.dius.tennis.random.RandomIntegerLessThan50.lessThan

class PlayersSpec extends Specification {
    private Players players

    def setup() {
        players = new Players(FIRST_PLAYER, SECOND_PLAYER)
    }

    def "a player starts with 0 points and every time it scores, it has more points"() {
        given:
        totalPointsWonByPlayer1.times {
            players.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        expect:
        players.playerWithNameHasPoints(FIRST_PLAYER, totalPointsWonByPlayer1)

        where:
        totalPointsWonByPlayer1 |_
        0                       |_
        greaterThan(0)          |_
    }

    def "asMap returns a key-value representation of players names and points"() {
        given:
        totalPointsWonByPlayer1.times {
            players.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        and:
        totalPointsWonByPlayer2.times {
            players.pointWonByPlayerWithName(SECOND_PLAYER)
        }

        expect:
        [FIRST_PLAYER: totalPointsWonByPlayer1, SECOND_PLAYER: totalPointsWonByPlayer2]

        where:
        totalPointsWonByPlayer1 | totalPointsWonByPlayer2
        greaterThan(0)          | greaterThan(0)
    }

    @Unroll
    def "bothPlayersHaveScoreMoreThanOrEqualsToPoints returns true when both players comply with the method name"() {
        given:
        totalPointsWonByPlayer1.times {
            players.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        and:
        totalPointsWonByPlayer2.times {
            players.pointWonByPlayerWithName(SECOND_PLAYER)
        }

        expect:
        bothPlayersHaveScored == players.bothPlayersHaveScoredMoreThanOrEqualsToPoints(pointsToVerify)

        where:
        totalPointsWonByPlayer1 | totalPointsWonByPlayer2 | pointsToVerify | bothPlayersHaveScored
        1                       | 1                       | greaterThan(2) | false
        1                       | 1                       | 1              | true
        2                       | 2                       | 1              | true
    }

    @Unroll
    def "bothPlayersHaveMininumScoreForDeuce returns true when both players have at least 3 points"() {
        given:
        totalPointsWonByPlayer1.times {
            players.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        and:
        totalPointsWonByPlayer2.times {
            players.pointWonByPlayerWithName(SECOND_PLAYER)
        }

        expect:
        isApplicable == players.bothPlayersHaveMininumScoreForDeuce()

        where:
        totalPointsWonByPlayer1 | totalPointsWonByPlayer2 | isApplicable
        lessThan(3)             | lessThan(3)             | false
        3                       | 3                       | true
        greaterThan(3)          | greaterThan(3)          | true
    }
}
