package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players

class DeuceStrategy extends AbstractStrategy {

    public static final String DEUCE = "Deuce"

    DeuceStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    DeuceStrategy(Players p) {
        this.players = p
    }

    boolean isApplicableToScore() {
        if (players) {
            return players.areInDeuce()
        }

        BothPlayersPreconditions.bothPlayersHaveMininumScoreForDeuce(player1Points, player2Points) &&
                ((player1Points - player2Points) == 0)
    }

    String displaySpecificScore() {
        return DEUCE
    }
}
