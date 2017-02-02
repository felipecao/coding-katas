package au.com.dius.tennis

class Game {

    public static final String INITIAL_SCORE = "0-0"

    private Players players
    private String winner = null
    private String score = INITIAL_SCORE

    Game(String player1Name, String player2Name) {
        players = new Players(player1Name, player2Name)
    }

    void pointWonBy(String playerName) {

        if(winner) {
            return;
        }

        players.pointWonByPlayerWithName(playerName)

        ScoreDisplayStrategy strategy = ScoreDisplayStrategyFactory.buildForNamesAndPoints(players.asMap())

        score = strategy.displayScore()
        winner = strategy.winner()
    }

    String score() {
        return score
    }
}
