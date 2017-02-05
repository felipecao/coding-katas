package au.com.dius.tennis.strategy

import au.com.dius.tennis.Score
import au.com.dius.tennis.rules.DeuceRules

class DeuceStrategy extends AbstractStrategy {

    protected static final String DEUCE = "Deuce"

    DeuceStrategy(final Score s) {
        this.score = s
    }

    boolean isApplicableToScore() {
        DeuceRules.isDeuce(score)
    }

    String displaySpecificScore() {
        return DEUCE
    }
}
