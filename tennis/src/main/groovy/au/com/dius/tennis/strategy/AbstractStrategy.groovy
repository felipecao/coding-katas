package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players
import au.com.dius.tennis.ScoreDisplayStrategy

import static org.apache.commons.lang3.StringUtils.EMPTY

abstract class AbstractStrategy implements ScoreDisplayStrategy {

    protected Players players

    abstract boolean isApplicableToScore()

    abstract String displaySpecificScore()

    String displayScore() {
        if (!isApplicableToScore()) {
            return EMPTY
        }

        return displaySpecificScore()
    }
}
