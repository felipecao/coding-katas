package au.com.dius.tennis.rules

import au.com.dius.tennis.Score

class VictoryRules {

    private static final Integer MINIMUM_POINTS_FOR_VICTORY = 4
    private static final Integer POINTS_DIFFERENCE_FOR_VICTORY = 2

    static boolean isVictory(Score score) {
        score.anyPlayerHasScoredMoreThanOrEqualsToPoints(MINIMUM_POINTS_FOR_VICTORY) &&
                score.differenceInPointsIsGreaterThanOrEqualsTo(POINTS_DIFFERENCE_FOR_VICTORY)
    }
}
