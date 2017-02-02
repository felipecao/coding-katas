package au.com.dius.tennis.strategy

import static java.lang.Math.abs

class AdvantageStrategy extends AbstractStrategy {

    public static final String ADVANTAGE = "Advantage"

    AdvantageStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    boolean isApplicableToScore() {
        BothPlayersPreconditions.bothPlayersHaveScoreAtLeast(player1Points, player2Points, 3) &&
            abs(pointsDifference) == 1
    }

    String displaySpecificScore() {
        "$ADVANTAGE ${pointsDifference == 1 ? player1Name : player2Name}"
    }
}
