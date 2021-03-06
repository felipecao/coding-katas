package au.com.dius.tennis.strategy

import au.com.dius.tennis.Score
import au.com.dius.tennis.rules.VictoryRules

class VictoryStrategy extends AbstractStrategy {

    protected static final String VICTORY = "wins"

    VictoryStrategy(final Score s) {
        this.score = s
    }

    boolean isApplicableToScore() {
        VictoryRules.isVictory(score)
    }

    String displaySpecificScore() {
        score.withNameOfCurrentlyWinningPlayer { String winner ->
            "$winner $VICTORY"
        }
    }

    @Override
    String winner() {
        score.withNameOfCurrentlyWinningPlayer { String winner ->
            winner
        }
    }
}
