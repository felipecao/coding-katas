package au.com.dius.tennis.strategy

import static java.lang.Math.abs

class VictoryStrategy extends AbstractStrategy {

    public static final String VICTORY = "wins"

    private String player1Name
    private String player2Name
    private int pointsDifference

    VictoryStrategy(Map<String, Integer> playersNamesAndPoints) {

        initializePlayersPoints(playersNamesAndPoints)

        player1Name = playersNamesAndPoints.keySet().first()
        player2Name = playersNamesAndPoints.keySet().last()

        pointsDifference = player1Points - player2Points
    }

    boolean isApplicableToScore() {
        (player1Points >= 4 || player2Points >= 4) && abs(pointsDifference) >= 2
    }

    String displaySpecificScore() {
        "${player1Points - player2Points > 0 ? player1Name : player2Name} $VICTORY"
    }
}
