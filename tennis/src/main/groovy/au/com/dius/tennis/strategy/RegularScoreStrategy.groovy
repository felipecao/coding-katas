package au.com.dius.tennis.strategy

import au.com.dius.tennis.Score
import au.com.dius.tennis.rules.RegularScoreRules

import static java.lang.Math.floor

class RegularScoreStrategy extends AbstractStrategy {

    RegularScoreStrategy(Score s) {
        this.score = s
    }

    boolean isApplicableToScore() {
        RegularScoreRules.isRegularScore(score)
    }

    String displaySpecificScore() {
        return score.withPlayersPoints { Integer p1, Integer p2 ->
            "${calculateScoreForPoints(p1)}-${calculateScoreForPoints(p2)}"
        }
    }

    private int calculateScoreForPoints(int p) {
        (p * 15) - (5 * floor(p/3))
    }
}
