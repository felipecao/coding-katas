package au.com.dius.tennis.strategy

import au.com.dius.tennis.Player
import au.com.dius.tennis.Score
import au.com.dius.tennis.ScoreDisplayStrategy
import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.PlayersNames.FIRST_PLAYER
import static au.com.dius.tennis.PlayersNames.SECOND_PLAYER
import static au.com.dius.tennis.random.RandomIntegerLessThan50.lessThan
import static org.apache.commons.lang3.StringUtils.EMPTY
import static au.com.dius.tennis.strategy.VictoryStrategy.VICTORY

class VictoryStrategySpec extends Specification {

    private ScoreDisplayStrategy strategy

    @Unroll
    def "VictoryStrategy should display '#score' when player 1 scores #player1Points and player 2 scores #player2Points"() {
        given:
        strategy = new VictoryStrategy(new Score(
                new Player(FIRST_PLAYER, player1Points),
                new Player(SECOND_PLAYER, player2Points)
        ))

        expect:
        score == strategy.displayScore()

        where:
        player1Points | player2Points | score
        lessThan(4)   | lessThan(4)   | EMPTY
        4             | 3             | EMPTY
        5             | 5             | EMPTY
        5             | 3             | "$FIRST_PLAYER $VICTORY"
        3             | 5             | "$SECOND_PLAYER $VICTORY"
        7             | 5             | "$FIRST_PLAYER $VICTORY"
    }

    @Unroll
    def "VictoryStrategy is not applicable if players have less than 4 points or have a difference smaller than 2 points"() {
        given:
        strategy = new VictoryStrategy(new Score(
                new Player(FIRST_PLAYER, player1Points),
                new Player(SECOND_PLAYER, player2Points)
        ))

        expect:
        isApplicable == strategy.isApplicableToScore()

        where:
        player1Points | player2Points | isApplicable
        lessThan(4)   | lessThan(4)   | false
        4             | 3             | false
        5             | 5             | false
        5             | 3             | true
        3             | 5             | true
        7             | 5             | true
    }

    @Unroll
    def "'#winner' should be the winner when player 1 scores #player1Points and player 2 scores #player2Points"() {
        given:
        strategy = new VictoryStrategy(new Score(
                new Player(FIRST_PLAYER, player1Points),
                new Player(SECOND_PLAYER, player2Points)
        ))

        expect:
        winner == strategy.winner()

        where:
        player1Points | player2Points | winner
        5             | 3             | FIRST_PLAYER
        3             | 5             | SECOND_PLAYER
        7             | 5             | FIRST_PLAYER
    }

}
