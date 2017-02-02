package au.com.dius.tennis.strategy

import spock.lang.Specification
import spock.lang.Unroll

class RegularScoreStrategySpec extends Specification {

    private static final String BLANK = ""

    private RegularScoreStrategy strategy

    @Unroll
    def "RegularScoreStrategy should display '#score' when player 1 scores #player1Points and player 2 scores #player2Points"() {
        given:
        strategy = new RegularScoreStrategy(player1Points, player2Points)

        expect:
        score == strategy.displayScore()

        where:
        player1Points | player2Points | score
        0             | 0             | "0-0"
        1             | 0             | "15-0"
        2             | 0             | "30-0"
        3             | 0             | "40-0"
        0             | 1             | "0-15"
        0             | 2             | "0-30"
        0             | 3             | "0-40"
        1             | 1             | "15-15"
        2             | 2             | "30-30"
        2             | 1             | "30-15"
        1             | 2             | "15-30"
        3             | 1             | "40-15"
        1             | 3             | "15-40"
        3             | 2             | "40-30"
        2             | 3             | "30-40"
        3             | 3             | BLANK
        4             | 3             | BLANK
        3             | 4             | BLANK
        4             | 4             | BLANK
    }

    @Unroll
    def "RegularScoreStrategy is not applicable if any player has scored over 3 points"() {
        given:
        strategy = new RegularScoreStrategy(player1Points, player2Points)

        expect:
        isApplicable == strategy.isApplicableToScore()

        where:
        player1Points | player2Points | isApplicable
        0             | 0             | true
        1             | 0             | true
        2             | 0             | true
        3             | 0             | true
        0             | 1             | true
        0             | 2             | true
        0             | 3             | true
        1             | 1             | true
        2             | 2             | true
        2             | 1             | true
        1             | 2             | true
        3             | 1             | true
        1             | 3             | true
        3             | 2             | true
        2             | 3             | true
        3             | 3             | false
        4             | 3             | false
        3             | 4             | false
        4             | 4             | false
    }

}
