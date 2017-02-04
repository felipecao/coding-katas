package au.com.dius.tennis.rules

import au.com.dius.tennis.Score

class RegularScoreRules {
    static boolean isRegularScore(Score score) {
        !score.bothPlayersHaveAtLeast3Points() &&
                score.playersDontHaveNegativeScore()
    }
}
