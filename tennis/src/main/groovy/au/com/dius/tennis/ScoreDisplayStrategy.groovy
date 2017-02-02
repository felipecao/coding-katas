package au.com.dius.tennis

import static org.apache.commons.lang3.StringUtils.EMPTY

trait ScoreDisplayStrategy {

    abstract boolean isApplicableToScore()
    abstract String displayScore()

    String winner() {
        EMPTY
    }
}
