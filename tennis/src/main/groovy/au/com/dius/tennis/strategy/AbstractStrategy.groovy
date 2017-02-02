package au.com.dius.tennis.strategy

abstract class AbstractStrategy implements ScoreDisplayStrategy {

    public static final String BLANK = ""

    protected Integer player1Points
    protected Integer player2Points

    protected String player1Name
    protected String player2Name

    protected Integer pointsDifference

    abstract boolean isApplicableToScore()

    abstract String displaySpecificScore()

    String displayScore() {
        if (!isApplicableToScore()) {
            return BLANK
        }

        return displaySpecificScore()
    }

    protected void initializePlayersNamesAndPoints(Map<String, Integer> playersNamesAndPoints) {
        player1Points = playersNamesAndPoints[playersNamesAndPoints.keySet()[0]]
        player2Points = playersNamesAndPoints[playersNamesAndPoints.keySet()[1]]

        player1Name = playersNamesAndPoints.keySet().first()
        player2Name = playersNamesAndPoints.keySet().last()

        pointsDifference = player1Points - player2Points
    }
}
