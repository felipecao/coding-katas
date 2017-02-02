package au.com.dius.tennis.strategy

import static java.lang.Math.floor

class RegularScoreStrategy extends AbstractStrategy {

    RegularScoreStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    boolean isApplicableToScore() {
        return !BothPlayersPreconditions.bothPlayersHaveMininumScoreForDeuce(player1Points, player2Points) &&
                BothPlayersPreconditions.bothPlayersHaveScoreAtLeast(player1Points, player2Points, 0)
    }

    String displaySpecificScore() {
        return "${calculateScoreForPoints(player1Points)}-${calculateScoreForPoints(player2Points)}"
    }

    private int calculateScoreForPoints(int p) {
        (p * 15) - (5 * floor(p/3))
    }
}
