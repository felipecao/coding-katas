package au.com.dius.tennis.strategy

import au.com.dius.tennis.preconditions.BothPlayersHaveScoredAtLeast40

import static java.lang.Math.floor

class RegularScoreStrategy {

    public static final String BLANK = ""

    private int player1Points
    private int player2Points

    RegularScoreStrategy(int player1Points, int player2Points) {
        this.player1Points = player1Points
        this.player2Points = player2Points
    }

    boolean isApplicableToScore() {
        return !BothPlayersHaveScoredAtLeast40.isApplicableToPoints(player1Points, player2Points)
    }

    String displayScore() {
        if (!isApplicableToScore()) {
            return BLANK
        }
        return "${calculateScoreForPoints(player1Points)}-${calculateScoreForPoints(player2Points)}"
    }

    private int calculateScoreForPoints(int p) {
        (p * 15) - (5 * floor(p/3))
    }
}
