package au.com.dius.tennis.strategy

import au.com.dius.tennis.Score
import au.com.dius.tennis.rules.AdvantageRules

class AdvantageStrategy extends AbstractStrategy {

    protected static final String ADVANTAGE = "Advantage"

    AdvantageStrategy(Score s) {
        this.score = s
    }

    boolean isApplicableToScore() {
        AdvantageRules.isAdvantage(score)
    }

    String displaySpecificScore() {
        return score.withNameOfCurrentlyWinningPlayer { String playerName ->
            "$ADVANTAGE $playerName"
        }
    }
}
