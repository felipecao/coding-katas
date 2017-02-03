package au.com.dius.tennis.strategy

import au.com.dius.tennis.Score

import static java.lang.Math.floor

class RegularScoreStrategy extends AbstractStrategy {

    private static final int MINIMUM_SCORE = 0

    RegularScoreStrategy(Score s) {
        this.score = s
    }

    boolean isApplicableToScore() {
        return !score.bothPlayersHaveAtLeast3Points() &&
                score.bothPlayersHaveScoredMoreThanOrEqualsToPoints(MINIMUM_SCORE)
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
