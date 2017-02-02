package au.com.dius.tennis.strategy

trait ScoreDisplayStrategy {
    abstract boolean isApplicableToScore()
    abstract String displayScore()
    String winner() {
        null
    }
}
