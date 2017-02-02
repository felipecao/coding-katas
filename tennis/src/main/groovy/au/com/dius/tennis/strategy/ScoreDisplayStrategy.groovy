package au.com.dius.tennis.strategy

interface ScoreDisplayStrategy {
    boolean isApplicableToScore()
    String displayScore()
}
