package au.com.dius.tennis.strategy

import au.com.dius.tennis.Score

import static org.apache.commons.lang3.StringUtils.EMPTY

class VictoryStrategy extends AbstractStrategy {

    public static final String VICTORY = "wins"
    public static final Integer MINIMUM_POINTS_FOR_VICTORY = 4
    public static final Integer POINTS_DIFFERENCE_FOR_VICTORY = 2

    VictoryStrategy(Score s) {
        this.score = s
    }

    boolean isApplicableToScore() {
        return score.anyPlayerHasScoredMoreThanOrEqualsToPoints(MINIMUM_POINTS_FOR_VICTORY) &&
                score.differenceInPointsIsGreaterThanOrEqualsTo(POINTS_DIFFERENCE_FOR_VICTORY)
    }

    String displaySpecificScore() {
        return score.withNameOfPlayerCurrentlyWinning { String winner ->
            "$winner $VICTORY"
        }
    }

    @Override
    String winner() {
        if (!isApplicableToScore()) {
            return EMPTY
        }

        return score.withNameOfPlayerCurrentlyWinning { String winner ->
            winner
        }
    }
}
