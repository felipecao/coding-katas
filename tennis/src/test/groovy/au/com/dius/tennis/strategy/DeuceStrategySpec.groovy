package au.com.dius.tennis.strategy

import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.random.RandomIntegerLessThan50.lessThan
import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan
import static au.com.dius.tennis.strategy.AbstractStrategy.BLANK
import static au.com.dius.tennis.strategy.DeuceStrategy.DEUCE

class DeuceStrategySpec extends Specification {

    private Strategy strategy

    @Unroll
    def "DeuceStrategy should display '#score' when player 1 scores #player1Points and player 2 scores #player2Points"() {
        given:
        strategy = new DeuceStrategy(player1Points, player2Points)

        expect:
        score == strategy.displayScore()

        where:
        player1Points  | player2Points  | score
        lessThan(3)    | lessThan(3)    | BLANK
        3              | 3              | DEUCE
        greaterThan(3) | 3              | BLANK
        3              | greaterThan(3) | BLANK
        4              | 4              | DEUCE
        5              | 5              | DEUCE
    }

    @Unroll
    def "DeuceStrategy is not applicable if players have less than 3 points and are not at a draw"() {
        given:
        strategy = new DeuceStrategy(player1Points, player2Points)

        expect:
        isApplicable == strategy.isApplicableToScore()

        where:
        player1Points  | player2Points  | isApplicable
        lessThan(3)    | lessThan(3)    | false
        3              | 3              | true
        greaterThan(3) | 3              | false
        3              | greaterThan(3) | false
        4              | 4              | true
        5              | 5              | true
    }

}
