package au.com.dius.tennis.strategy

import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.PlayersNames.FIRST_PLAYER
import static au.com.dius.tennis.PlayersNames.SECOND_PLAYER
import static au.com.dius.tennis.random.RandomIntegerLessThan50.lessThan
import static au.com.dius.tennis.strategy.AbstractStrategy.BLANK
import static au.com.dius.tennis.strategy.AdvantageStrategy.ADVANTAGE

class AdvantageStrategySpec extends Specification {

    private Strategy strategy

    @Unroll
    def "AdvantageStrategy should display '#score' when player 1 scores #player1Points and player 2 scores #player2Points"() {
        given:
        strategy = new AdvantageStrategy([
                ("$FIRST_PLAYER".toString()): player1Points,
                ("$SECOND_PLAYER".toString()): player2Points
        ])

        expect:
        score == strategy.displayScore()

        where:
        player1Points | player2Points | score
        lessThan(3)   | lessThan(3)   | BLANK
        3             | 3             | BLANK
        4             | 3             | "$ADVANTAGE $FIRST_PLAYER"
        3             | 4             | "$ADVANTAGE $SECOND_PLAYER"
        4             | 4             | BLANK
        4             | 5             | "$ADVANTAGE $SECOND_PLAYER"
        5             | 4             | "$ADVANTAGE $FIRST_PLAYER"
        9             | 8             | "$ADVANTAGE $FIRST_PLAYER"
        10            | 8             | BLANK
        12            | 8             | BLANK
    }

    @Unroll
    def "AdvantageStrategy is not applicable if players have less than 3 points or have a difference larger than 1 point"() {
        given:
        strategy = new AdvantageStrategy([
                ("$FIRST_PLAYER".toString()): player1Points,
                ("$SECOND_PLAYER".toString()): player2Points
        ])

        expect:
        isApplicable == strategy.isApplicableToScore()

        where:
        player1Points | player2Points | isApplicable
        lessThan(3)   | lessThan(3)   | false
        3             | 3             | false
        4             | 3             | true
        3             | 4             | true
        4             | 4             | false
        4             | 5             | true
        5             | 4             | true
        9             | 8             | true
        10            | 8             | false
        12            | 8             | false
    }

}
