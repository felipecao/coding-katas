package au.com.dius.tennis.strategy

import static java.lang.Math.abs

class VictoryStrategy extends AbstractStrategy {

    public static final String VICTORY = "wins"

    VictoryStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    boolean isApplicableToScore() {
        (player1Points >= 4 || player2Points >= 4) && abs(pointsDifference) >= 2
    }

    String displaySpecificScore() {
        "${player1Points - player2Points > 0 ? player1Name : player2Name} $VICTORY"
    }
}
