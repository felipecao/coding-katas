package au.com.dius.tennis

import static java.lang.Math.floor

class Game {

    private int points = 0

    Game(String player1Name, String player2Name) {

    }

    void pointWonBy(String playerName) {
        points++
    }

    String score() {
        "${calculateScoreForPoints(points)}-0"
    }

    private int calculateScoreForPoints(int p) {
        (p * 15) - (5 * floor(p/3))
    }
}
