package au.com.dius.tennis

import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.PlayersNames.FIRST_PLAYER
import static au.com.dius.tennis.PlayersNames.SECOND_PLAYER
import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan
import static au.com.dius.tennis.random.RandomIntegerLessThan50.lessThan

class ScoreSpec extends Specification {

    private Score score

    def setup() {
        score = new Score(FIRST_PLAYER, SECOND_PLAYER)
    }

    def "a player starts with 0 points and every time it scores, it has more points"() {
        given:
        totalPointsWonByPlayer1.times {
            score.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        expect:
        score.playerWithNameHasPoints(FIRST_PLAYER, totalPointsWonByPlayer1)

        where:
        totalPointsWonByPlayer1 | _
        0                       | _
        greaterThan(0)          | _
    }

    def "asMap returns a key-value representation of players names and points"() {
        given:
        totalPointsWonByPlayer1.times {
            score.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        and:
        totalPointsWonByPlayer2.times {
            score.pointWonByPlayerWithName(SECOND_PLAYER)
        }

        expect:
        [FIRST_PLAYER: totalPointsWonByPlayer1, SECOND_PLAYER: totalPointsWonByPlayer2]

        where:
        totalPointsWonByPlayer1 | totalPointsWonByPlayer2
        greaterThan(0)          | greaterThan(0)
    }

    @Unroll
    def "bothPlayersHaveScoredMoreThanOrEqualsToPoints returns true when both players comply with the method name"() {
        given:
        totalPointsWonByPlayer1.times {
            score.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        and:
        totalPointsWonByPlayer2.times {
            score.pointWonByPlayerWithName(SECOND_PLAYER)
        }

        expect:
        bothPlayersHaveScored == score.bothPlayersHaveScoredMoreThanOrEqualsToPoints(pointsToVerify)

        where:
        totalPointsWonByPlayer1 | totalPointsWonByPlayer2 | pointsToVerify | bothPlayersHaveScored
        1                       | 1                       | greaterThan(2) | false
        1                       | 1                       | 1              | true
        2                       | 2                       | 1              | true
    }

    @Unroll
    def "bothPlayersHaveAtLeast3Points returns true when both players have at least 3 points"() {
        given:
        totalPointsWonByPlayer1.times {
            score.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        and:
        totalPointsWonByPlayer2.times {
            score.pointWonByPlayerWithName(SECOND_PLAYER)
        }

        expect:
        isApplicable == score.bothPlayersHaveAtLeast3Points()

        where:
        totalPointsWonByPlayer1 | totalPointsWonByPlayer2 | isApplicable
        lessThan(3)             | lessThan(3)             | false
        3                       | 3                       | true
        greaterThan(3)          | greaterThan(3)          | true
    }

    @Unroll
    def "playersAreInDeuce returns true when both players have at least 3 points and are tied"() {
        given:
        totalPointsWonByPlayer1.times {
            score.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        and:
        totalPointsWonByPlayer2.times {
            score.pointWonByPlayerWithName(SECOND_PLAYER)
        }

        expect:
        areInDeuce == score.playersAreInDeuce()

        where:
        totalPointsWonByPlayer1 | totalPointsWonByPlayer2 | areInDeuce
        lessThan(3)             | lessThan(3)             | false
        3                       | 3                       | true
        4                       | 4                       | true
        5                       | 5                       | true
        6                       | 6                       | true
    }

    @Unroll
    def "differenceInPointsIs returns true when players have the difference provided as input"() {
        given:
        totalPointsWonByPlayer1.times {
            score.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        and:
        totalPointsWonByPlayer2.times {
            score.pointWonByPlayerWithName(SECOND_PLAYER)
        }

        expect:
        diffMatches == score.differenceInPointsIs(diff)

        where:
        totalPointsWonByPlayer1 | totalPointsWonByPlayer2 | diff | diffMatches
        0                       | 0                       | 1    | false
        0                       | 0                       | 0    | true
        1                       | 0                       | 1    | true
        0                       | 1                       | 1    | true
        0                       | 1                       | -1   | false
    }

    @Unroll
    def "anyPlayerHasScoredMoreThanOrEqualsToPoints returns true when any players has scored at least the points provided as input"() {
        given:
        totalPointsWonByPlayer1.times {
            score.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        and:
        totalPointsWonByPlayer2.times {
            score.pointWonByPlayerWithName(SECOND_PLAYER)
        }

        expect:
        anyoneHasScored == score.anyPlayerHasScoredMoreThanOrEqualsToPoints(threshold)

        where:
        totalPointsWonByPlayer1 | totalPointsWonByPlayer2 | threshold | anyoneHasScored
        0                       | 0                       | 1         | false
        0                       | 0                       | 0         | true
        1                       | 0                       | 1         | true
        0                       | 1                       | 1         | true
        2                       | 1                       | 1         | true
        1                       | 2                       | 1         | true
    }

    @Unroll
    def "differenceInPointsIsGreaterThanOrEqualsTo returns #isApplicable when player 1 has scored #totalPointsWonByPlayer1 and player 2 has scored #totalPointsWonByPlayer2"() {
        given:
        totalPointsWonByPlayer1.times {
            score.pointWonByPlayerWithName(FIRST_PLAYER)
        }

        and:
        totalPointsWonByPlayer2.times {
            score.pointWonByPlayerWithName(SECOND_PLAYER)
        }

        expect:
        isApplicable == score.differenceInPointsIsGreaterThanOrEqualsTo(diff)

        where:
        totalPointsWonByPlayer1 | totalPointsWonByPlayer2 | diff | isApplicable
        0                       | 0                       | 1    | false
        0                       | 0                       | 0    | true
        1                       | 0                       | 1    | true
        0                       | 1                       | 1    | true
        2                       | 0                       | 2    | true
    }

}
