package au.com.dius.tennis.strategy

import au.com.dius.tennis.preconditions.BothPlayersHaveScoredAtLeast40

import static java.lang.Math.abs

class AdvantageStrategy extends AbstractStrategy {

    public static final String ADVANTAGE = "Advantage"

    private String player1Name
    private String player2Name
    private int pointsDifference

    AdvantageStrategy(Map<String, Integer> playersNamesAndPoints) {

        initializePlayersPoints(playersNamesAndPoints)

        player1Name = playersNamesAndPoints.keySet().first()
        player2Name = playersNamesAndPoints.keySet().last()

        pointsDifference = player1Points - player2Points
    }

    boolean isApplicableToScore() {
        BothPlayersHaveScoredAtLeast40.isApplicableToPoints(player1Points, player2Points) &&
            abs(pointsDifference) == 1
    }

    String displaySpecificScore() {
        "$ADVANTAGE ${pointsDifference == 1 ? player1Name : player2Name}"
    }
}
