package au.com.dius.tennis.strategy

class DeuceStrategy extends AbstractStrategy {

    public static final String DEUCE = "Deuce"

    DeuceStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    boolean isApplicableToScore() {
        BothPlayersPreconditions.isApplicableToPoints(player1Points, player2Points) &&
                ((player1Points - player2Points) == 0)
    }

    String displaySpecificScore() {
        return DEUCE
    }
}
