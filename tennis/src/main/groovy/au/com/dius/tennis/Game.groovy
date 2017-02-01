package au.com.dius.tennis

class Game {

    private int points = 0

    Game(String player1Name, String player2Name) {

    }

    void pointWonBy(String playerName) {
        points++
    }

    String score() {
        "${points * 15}-0"
    }
}
