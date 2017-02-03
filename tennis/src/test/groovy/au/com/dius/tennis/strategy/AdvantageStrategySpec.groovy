package au.com.dius.tennis.strategy

import au.com.dius.tennis.Player
import au.com.dius.tennis.Players
import au.com.dius.tennis.ScoreDisplayStrategy
import au.com.dius.tennis.random.RandomString16CharsLong
import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.PlayersNames.FIRST_PLAYER
import static au.com.dius.tennis.PlayersNames.SECOND_PLAYER
import static au.com.dius.tennis.random.RandomIntegerLessThan50.lessThan
import static org.apache.commons.lang3.StringUtils.EMPTY
import static au.com.dius.tennis.strategy.AdvantageStrategy.ADVANTAGE

class AdvantageStrategySpec extends Specification {

    private ScoreDisplayStrategy strategy

    @Unroll
    def "AdvantageStrategy should display '#score' when player 1 scores #player1Points and player 2 scores #player2Points"() {
        given:
        strategy = new AdvantageStrategy(new Players(
                new Player(FIRST_PLAYER, player1Points),
                new Player(SECOND_PLAYER, player2Points)
        ))

        expect:
        score == strategy.displayScore()

        where:
        player1Points | player2Points | score
        lessThan(3)   | lessThan(3)   | EMPTY
        3             | 3             | EMPTY
        4             | 3             | "$ADVANTAGE $FIRST_PLAYER"
        3             | 4             | "$ADVANTAGE $SECOND_PLAYER"
        4             | 4             | EMPTY
        4             | 5             | "$ADVANTAGE $SECOND_PLAYER"
        5             | 4             | "$ADVANTAGE $FIRST_PLAYER"
        9             | 8             | "$ADVANTAGE $FIRST_PLAYER"
        10            | 8             | EMPTY
        12            | 8             | EMPTY
    }

    @Unroll
    def "AdvantageStrategy is not applicable if players have less than 3 points or have a difference larger than 1 point"() {
        given:
        strategy = new AdvantageStrategy(new Players(
                new Player(FIRST_PLAYER, player1Points),
                new Player(SECOND_PLAYER, player2Points)
        ))

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
