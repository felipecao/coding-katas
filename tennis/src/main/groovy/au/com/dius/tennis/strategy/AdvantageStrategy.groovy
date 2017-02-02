package au.com.dius.tennis.strategy

import au.com.dius.tennis.precondition.BothPlayersPreconditions

import static java.lang.Math.abs

class AdvantageStrategy extends AbstractStrategy {

    public static final String ADVANTAGE = "Advantage"

    AdvantageStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    boolean isApplicableToScore() {
        BothPlayersPreconditions.isApplicableToPoints(player1Points, player2Points) &&
            abs(pointsDifference) == 1
    }

    String displaySpecificScore() {
        "$ADVANTAGE ${pointsDifference == 1 ? player1Name : player2Name}"
    }
}
