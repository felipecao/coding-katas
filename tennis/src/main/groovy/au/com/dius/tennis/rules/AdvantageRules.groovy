package au.com.dius.tennis.rules

import au.com.dius.tennis.Score

class AdvantageRules {

    private static final Integer DIFFERENCE_IN_POINTS_FOR_ADVANTAGE = 1

    static boolean isAdvantage(Score score) {
        score.bothPlayersHaveAtLeast3Points() &&
                score.differenceInPointsIs(DIFFERENCE_IN_POINTS_FOR_ADVANTAGE)
    }
}
