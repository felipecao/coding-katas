package au.com.dius.tennis.strategy

interface Strategy {
    boolean isApplicableToScore()

    String displayScore()
}
