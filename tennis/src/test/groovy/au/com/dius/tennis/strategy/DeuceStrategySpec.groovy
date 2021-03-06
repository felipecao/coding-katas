package au.com.dius.tennis.strategy

import au.com.dius.tennis.Player
import au.com.dius.tennis.Score
import au.com.dius.tennis.ScoreDisplayStrategy
import au.com.dius.tennis.random.RandomString16CharsLong
import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.random.RandomIntegerLessThan50.lessThan
import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan
import static org.apache.commons.lang3.StringUtils.EMPTY
import static au.com.dius.tennis.strategy.DeuceStrategy.DEUCE

class DeuceStrategySpec extends Specification {

    private ScoreDisplayStrategy strategy

    @Unroll
    def "DeuceStrategy should display '#score' when player 1 scores #player1Points and player 2 scores #player2Points"() {
        given:
        strategy = new DeuceStrategy(new Score(
                new Player(RandomString16CharsLong.get(), player1Points),
                new Player(RandomString16CharsLong.get(), player2Points)
        ))

        expect:
        score == strategy.displayScore()

        where:
        player1Points  | player2Points  | score
        lessThan(3)    | lessThan(3)    | EMPTY
        3              | 3              | DEUCE
        greaterThan(3) | 3              | EMPTY
        3              | greaterThan(3) | EMPTY
        4              | 4              | DEUCE
        5              | 5              | DEUCE
    }

    @Unroll
    def "DeuceStrategy is not applicable if players have less than 3 points and are not at a draw"() {
        given:
        strategy = new DeuceStrategy(new Score(
                new Player(RandomString16CharsLong.get(), player1Points),
                new Player(RandomString16CharsLong.get(), player2Points)
        ))

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
