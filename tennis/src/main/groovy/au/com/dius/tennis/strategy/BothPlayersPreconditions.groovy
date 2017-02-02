package au.com.dius.tennis.strategy

class BothPlayersPreconditions {

    static boolean bothPlayersHaveScoreAtLeast(Integer player1Points, Integer player2Points, Integer atLeastPoints) {
        player1Points >= atLeastPoints && player2Points >= atLeastPoints
    }

}
