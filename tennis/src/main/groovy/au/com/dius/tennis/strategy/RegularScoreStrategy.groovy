package au.com.dius.tennis.strategy

import au.com.dius.tennis.preconditions.BothPlayersHaveScoredAtLeast40

import static java.lang.Math.floor

class RegularScoreStrategy extends AbstractStrategy {

    private int player1Points
    private int player2Points

    RegularScoreStrategy(Map<String, Integer> playersNamesAndPoints) {
        player1Points = playersNamesAndPoints[playersNamesAndPoints.keySet()[0]]
        player2Points = playersNamesAndPoints[playersNamesAndPoints.keySet()[1]]
    }

    boolean isApplicableToScore() {
        return !BothPlayersHaveScoredAtLeast40.isApplicableToPoints(player1Points, player2Points)
    }

    String displaySpecificScore() {
        return "${calculateScoreForPoints(player1Points)}-${calculateScoreForPoints(player2Points)}"
    }

    private int calculateScoreForPoints(int p) {
        (p * 15) - (5 * floor(p/3))
    }
}
