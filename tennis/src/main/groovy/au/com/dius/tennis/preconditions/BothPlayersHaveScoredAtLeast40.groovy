package au.com.dius.tennis.preconditions

class BothPlayersHaveScoredAtLeast40 {

    static boolean isApplicableToPoints(int player1Points, int player2Points) {
        player1Points >= 3 && player2Points >= 3
    }

}
