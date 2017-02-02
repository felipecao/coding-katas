package au.com.dius.tennis

import spock.lang.Specification

import static au.com.dius.tennis.PlayersNames.FIRST_PLAYER
import static au.com.dius.tennis.PlayersNames.SECOND_PLAYER
import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan

class PlayersSpec extends Specification {
    private Players players

    def setup() {
        players = new Players(FIRST_PLAYER, SECOND_PLAYER)
    }

    def "a player starts with 0 points and every time it scores, it has more points"() {
        given:
        totalScores.times {
            players.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        expect:
        players.playerWithNameHasPoints(FIRST_PLAYER, totalScores)

        where:
        totalScores |_
        0 |_
        greaterThan(0) |_
    }
}
