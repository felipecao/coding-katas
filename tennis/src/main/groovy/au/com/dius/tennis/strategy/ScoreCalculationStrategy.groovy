package au.com.dius.tennis.strategy

interface ScoreCalculationStrategy {
    boolean isApplicableToScore()
    String displayScore()
}
