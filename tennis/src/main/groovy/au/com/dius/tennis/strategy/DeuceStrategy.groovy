package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players

class DeuceStrategy extends AbstractStrategy {

    public static final String DEUCE = "Deuce"

    DeuceStrategy(Players p) {
        this.players = p
    }

    boolean isApplicableToScore() {
        players.areInDeuce()
    }

    String displaySpecificScore() {
        return DEUCE
    }
}
