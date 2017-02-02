package au.com.dius.tennis.strategy

import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.strategy.BothPlayersPreconditions.bothPlayersHaveScoreAtLeast
import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan

class BothPlayersPreconditionsSpec extends Specification {

    @Unroll
    def "bothPlayersHaveScoreAtLeast only applies if both players have scored at least the target amount of points"() {
        given:
        Integer targetPoints = 3

        expect:
        isApplicable == bothPlayersHaveScoreAtLeast(player1Points, player2Points, targetPoints)

        where:
        player1Points  | player2Points  | isApplicable
        0              | 0              | false
        1              | 0              | false
        2              | 0              | false
        3              | 0              | false
        0              | 1              | false
        0              | 2              | false
        0              | 3              | false
        1              | 1              | false
        2              | 2              | false
        2              | 1              | false
        1              | 2              | false
        3              | 1              | false
        1              | 3              | false
        3              | 2              | false
        2              | 3              | false
        3              | 3              | true
        greaterThan(3) | 3              | true
        3              | greaterThan(3) | true
        greaterThan(3) | greaterThan(3) | true
    }
}
