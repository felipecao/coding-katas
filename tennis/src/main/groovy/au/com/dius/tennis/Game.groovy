package au.com.dius.tennis

import static java.lang.Math.floor

class Game {

    private Map<String, Integer> points = [:]

    Game(String player1Name, String player2Name) {
        points << [("$player1Name".toString()): 0]
        points << [("$player2Name".toString()): 0]
    }

    void pointWonBy(String playerName) {
        points[playerName]++
    }

    String score() {

        if (playersHaveBothScoreAtLeast40() && player1Points() == player2Points()) {
            return "Deuce"
        }

        int pointsDifference = player1Points() - player2Points()

        if (playersHaveBothScoreAtLeast40() && pointsDifference in [1, -1]) {
            return "Advantage ${pointsDifference == 1 ? player1Name() : player2Name()}"
        }

        if (playersHaveBothScoreAtLeast40() && pointsDifference in [2, -2]) {
            return "${pointsDifference == 2 ? player1Name() : player2Name()} wins"
        }

        return "${calculateScoreForPoints(player1Points())}-${calculateScoreForPoints(player2Points())}"
    }

    private boolean playersHaveBothScoreAtLeast40() {
        player1Points() >= 3 && player2Points() >= 3
    }

    private String player1Name() {
        points.keySet().first()
    }

    private String player2Name() {
        points.keySet().last()
    }

    private int player1Points() {
        pointsForPlayer(0)
    }

    private int player2Points() {
        pointsForPlayer(1)
    }

    private int pointsForPlayer(int index) {
        points[points.keySet()[index]]
    }

    private int calculateScoreForPoints(int p) {
        (p * 15) - (5 * floor(p/3))
    }
}
