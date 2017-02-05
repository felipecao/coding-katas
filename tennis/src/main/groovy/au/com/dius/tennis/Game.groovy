package au.com.dius.tennis

class Game {

    private static final String INITIAL_SCORE = "0-0"

    private Score score
    private String winner = null
    private String scoreToDisplay = INITIAL_SCORE

    Game(String player1Name, String player2Name) {
        score = new Score(player1Name, player2Name)
    }

    void pointWonBy(String playerName) {

        if(winner) {
            return;
        }

        score.pointWonByPlayerWithName(playerName)

        ScoreDisplayStrategy strategy = ScoreDisplayStrategyFactory.buildStrategyForScore(score)

        scoreToDisplay = strategy.displayScore()
        winner = strategy.winner()
    }

    String score() {
        return scoreToDisplay
    }
}
