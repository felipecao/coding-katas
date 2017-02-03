package au.com.dius.tennis.strategy

import au.com.dius.tennis.Player
import au.com.dius.tennis.Score
import au.com.dius.tennis.ScoreDisplayStrategy
import au.com.dius.tennis.random.RandomString16CharsLong
import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan
import static org.apache.commons.lang3.StringUtils.EMPTY

class RegularScoreStrategySpec extends Specification {

    private ScoreDisplayStrategy strategy

    @Unroll
    def "RegularScoreStrategy should display '#score' when player 1 scores #player1Points and player 2 scores #player2Points"() {
        given:
        strategy = new RegularScoreStrategy(new Score(
                new Player(RandomString16CharsLong.get(), player1Points),
                new Player(RandomString16CharsLong.get(), player2Points)
        ))

        expect:
        score == strategy.displayScore()

        where:
        player1Points  | player2Points  | score
        0              | 0              | "0-0"
        1              | 0              | "15-0"
        2              | 0              | "30-0"
        3              | 0              | "40-0"
        0              | 1              | "0-15"
        0              | 2              | "0-30"
        0              | 3              | "0-40"
        1              | 1              | "15-15"
        2              | 2              | "30-30"
        2              | 1              | "30-15"
        1              | 2              | "15-30"
        3              | 1              | "40-15"
        1              | 3              | "15-40"
        3              | 2              | "40-30"
        2              | 3              | "30-40"
        greaterThan(3) | greaterThan(3) | EMPTY
    }

    @Unroll
    def "RegularScoreStrategy is not applicable if any player has scored over 3 points"() {
        given:
        strategy = new RegularScoreStrategy(new Score(
                new Player(RandomString16CharsLong.get(), player1Points),
                new Player(RandomString16CharsLong.get(), player2Points)
        ))

        expect:
        isApplicable == strategy.isApplicableToScore()

        where:
        player1Points  | player2Points  | isApplicable
        0              | 0              | true
        1              | 0              | true
        2              | 0              | true
        3              | 0              | true
        0              | 1              | true
        0              | 2              | true
        0              | 3              | true
        1              | 1              | true
        2              | 2              | true
        2              | 1              | true
        1              | 2              | true
        3              | 1              | true
        1              | 3              | true
        3              | 2              | true
        2              | 3              | true
        greaterThan(3) | greaterThan(3) | false
    }

}
