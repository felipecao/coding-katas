package au.com.dius.tennis.strategy

import au.com.dius.tennis.preconditions.BothPlayersHaveScoredAtLeast40

class DeuceStrategy {

    public static final String DEUCE = "Deuce"

    private int player1Points
    private int player2Points

    DeuceStrategy(int player1Points, int player2Points) {
        this.player1Points = player1Points
        this.player2Points = player2Points
    }

    boolean isApplicableToScore() {
        BothPlayersHaveScoredAtLeast40.isApplicableToPoints(player1Points, player2Points) &&
                ((player1Points - player2Points) == 0)
    }

    String displayScore() {
        if (!isApplicableToScore()) {
            return RegularScoreStrategy.BLANK
        }

        return DEUCE
    }
}
