package au.com.dius.tennis.strategy

abstract class AbstractStrategy implements ScoreCalculationStrategy {

    public static final String BLANK = ""

    abstract boolean isApplicableToScore()

    abstract String displaySpecificScore()

    String displayScore() {
        if (!isApplicableToScore()) {
            return BLANK
        }

        return displaySpecificScore()
    }
}