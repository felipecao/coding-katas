package au.com.dius.tennis

import au.com.dius.tennis.strategy.ScoreDisplayStrategy
import au.com.dius.tennis.strategy.ScoreDisplayStrategyFactory

class Game {

    public static final String INITIAL_SCORE = "0-0"

    private Map<String, Integer> points = [:]
    private String winner = null
    private String score = INITIAL_SCORE

    Game(String player1Name, String player2Name) {
        points << [("$player1Name".toString()): 0]
        points << [("$player2Name".toString()): 0]
    }

    void pointWonBy(String playerName) {

        if(winner) {
            return;
        }

        points[playerName]++

        ScoreDisplayStrategy strategy = ScoreDisplayStrategyFactory.buildForNamesAndPoints(points)

        score = strategy.displayScore()
        winner = strategy.winner()
    }

    String score() {
        return score
    }
}
