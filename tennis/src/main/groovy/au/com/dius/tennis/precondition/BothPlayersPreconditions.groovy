package au.com.dius.tennis.precondition

class BothPlayersPreconditions {

    static boolean isApplicableToPoints(int player1Points, int player2Points) {
        player1Points >= 3 && player2Points >= 3
    }

}
