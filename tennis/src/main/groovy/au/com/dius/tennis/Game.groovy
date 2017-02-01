package au.com.dius.tennis

class Game {

    private int times = 0

    Game(String player1Name, String player2Name) {

    }

    void pointWonBy(String playerName) {
        times++
    }

    String score() {
        "${times * 15}-0"
    }
}
