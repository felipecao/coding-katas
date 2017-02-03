package au.com.dius.tennis.strategy

import au.com.dius.tennis.Score

class AdvantageStrategy extends AbstractStrategy {

    protected static final String ADVANTAGE = "Advantage"
    private static final Integer POINTS_DIFFERENCE_FOR_ADVANTAGE = 1

    AdvantageStrategy(Score s) {
        this.score = s
    }

    boolean isApplicableToScore() {
        return score.bothPlayersHaveAtLeast3Points() &&
                score.differenceInPointsIs(POINTS_DIFFERENCE_FOR_ADVANTAGE)
    }

    String displaySpecificScore() {
        return score.withNameOfCurrentlyWinningPlayer { String playerName ->
            "$ADVANTAGE $playerName"
        }
    }
}
