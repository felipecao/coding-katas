package au.com.dius.tennis

import static java.lang.Math.floor

class Game {

    private Map<String, Integer> points = [:]
    private List<String> players = []

    Game(String player1Name, String player2Name) {
        points << [("$player1Name".toString()): 0]
        points << [("$player2Name".toString()): 0]

        players << player1Name
        players << player2Name
    }

    void pointWonBy(String playerName) {
        points[playerName]++
    }

    String score() {
        "${calculateScoreForPoints(points[players[0]])}-${calculateScoreForPoints(points[players[1]])}"
    }

    private int calculateScoreForPoints(int p) {
        (p * 15) - (5 * floor(p/3))
    }
}
