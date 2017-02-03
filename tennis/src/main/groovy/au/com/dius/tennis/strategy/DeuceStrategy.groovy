package au.com.dius.tennis.strategy

import au.com.dius.tennis.Score

class DeuceStrategy extends AbstractStrategy {

    public static final String DEUCE = "Deuce"

    DeuceStrategy(Score s) {
        this.score = s
    }

    boolean isApplicableToScore() {
        score.areInDeuce()
    }

    String displaySpecificScore() {
        return DEUCE
    }
}
