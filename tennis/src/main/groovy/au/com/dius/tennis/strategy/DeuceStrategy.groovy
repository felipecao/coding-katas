package au.com.dius.tennis.strategy

import au.com.dius.tennis.preconditions.BothPlayersHaveScoredAtLeast40

class DeuceStrategy extends AbstractStrategy {

    public static final String DEUCE = "Deuce"

    DeuceStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    boolean isApplicableToScore() {
        BothPlayersHaveScoredAtLeast40.isApplicableToPoints(player1Points, player2Points) &&
                ((player1Points - player2Points) == 0)
    }

    String displaySpecificScore() {
        return DEUCE
    }
}
