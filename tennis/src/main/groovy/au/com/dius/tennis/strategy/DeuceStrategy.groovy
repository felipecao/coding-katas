package au.com.dius.tennis.strategy

import au.com.dius.tennis.preconditions.BothPlayersHaveScoredAtLeast40

class DeuceStrategy extends AbstractStrategy {

    public static final String DEUCE = "Deuce"

    private int player1Points
    private int player2Points

    DeuceStrategy(Map<String, Integer> playersNamesAndPoints) {
        player1Points = playersNamesAndPoints[playersNamesAndPoints.keySet()[0]]
        player2Points = playersNamesAndPoints[playersNamesAndPoints.keySet()[1]]
    }

    boolean isApplicableToScore() {
        BothPlayersHaveScoredAtLeast40.isApplicableToPoints(player1Points, player2Points) &&
                ((player1Points - player2Points) == 0)
    }

    String displaySpecificScore() {
        return DEUCE
    }
}
