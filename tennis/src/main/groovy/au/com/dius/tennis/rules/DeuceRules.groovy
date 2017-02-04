package au.com.dius.tennis.rules

import au.com.dius.tennis.Score

class DeuceRules {
    static boolean isDeuce(Score score) {
        score.bothPlayersHaveAtLeast3Points() && score.playersHaveSameNumberOfPoints()
    }
}
