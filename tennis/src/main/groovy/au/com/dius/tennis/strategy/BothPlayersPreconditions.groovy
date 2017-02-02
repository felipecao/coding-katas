package au.com.dius.tennis.strategy

class BothPlayersPreconditions {

    private static boolean bothPlayersHaveScoreAtLeast(Integer player1Points, Integer player2Points, Integer atLeastPoints) {
        player1Points >= atLeastPoints && player2Points >= atLeastPoints
    }

    static boolean bothPlayersHaveMininumScoreForDeuce(Integer player1Points, Integer player2Points) {
        bothPlayersHaveScoreAtLeast(player1Points, player2Points, 3)
    }

}
