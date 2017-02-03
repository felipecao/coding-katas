package au.com.dius.tennis.strategy

import au.com.dius.tennis.Score

class AdvantageStrategy extends AbstractStrategy {

    public static final String ADVANTAGE = "Advantage"
    private static final Integer POINTS_DIFFERENCE_FOR_ADVANTAGE = 1

    AdvantageStrategy(Score s) {
        this.score = s
    }

    boolean isApplicableToScore() {
        return score.bothHaveMininumScoreForDeuce() &&
                score.differenceInPointsIs(POINTS_DIFFERENCE_FOR_ADVANTAGE)
    }

    String displaySpecificScore() {
        return score.withNameOfPlayerCurrentlyWinning { String playerName ->
            "$ADVANTAGE $playerName"
        }
    }
}
