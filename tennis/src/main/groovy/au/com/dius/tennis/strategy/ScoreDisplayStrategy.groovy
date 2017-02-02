package au.com.dius.tennis.strategy

import static org.apache.commons.lang3.StringUtils.EMPTY

trait ScoreDisplayStrategy {

    abstract boolean isApplicableToScore()
    abstract String displayScore()

    String winner() {
        EMPTY
    }
}
