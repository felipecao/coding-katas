package au.com.dius.tennis.strategy

abstract class AbstractStrategy implements ScoreCalculationStrategy {

    protected Integer player1Points
    protected Integer player2Points

    public static final String BLANK = ""

    abstract boolean isApplicableToScore()

    abstract String displaySpecificScore()

    String displayScore() {
        if (!isApplicableToScore()) {
            return BLANK
        }

        return displaySpecificScore()
    }

    protected void initializePlayersPoints(Map<String, Integer> playersNamesAndPoints) {
        player1Points = playersNamesAndPoints[playersNamesAndPoints.keySet()[0]]
        player2Points = playersNamesAndPoints[playersNamesAndPoints.keySet()[1]]
    }
}
