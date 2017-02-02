package au.com.dius.tennis.strategy

import au.com.dius.tennis.string.Strings

trait ScoreDisplayStrategy {

    abstract boolean isApplicableToScore()
    abstract String displayScore()

    String winner() {
        Strings.BLANK
    }
}
