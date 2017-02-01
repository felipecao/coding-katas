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
        if (player1Points() == 3 && player2Points() == 3) {
            return "Deuce"
        }
        return "${calculateScoreForPoints(player1Points())}-${calculateScoreForPoints(player2Points())}"
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
