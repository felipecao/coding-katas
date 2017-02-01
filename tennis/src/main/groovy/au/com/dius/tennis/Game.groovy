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
        if (points[points.keySet()[0]] == 3 && points[points.keySet()[1]] == 3) {
            return "Deuce"
        }
        return "${calculateScoreForPoints(points[points.keySet()[0]])}-${calculateScoreForPoints(points[points.keySet()[1]])}"
    }

    private int calculateScoreForPoints(int p) {
        (p * 15) - (5 * floor(p/3))
    }
}
