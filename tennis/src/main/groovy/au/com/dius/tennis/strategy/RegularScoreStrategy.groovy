package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players

import static java.lang.Math.floor

class RegularScoreStrategy extends AbstractStrategy {

    RegularScoreStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    RegularScoreStrategy(Players p) {
        this.players = p
    }

    boolean isApplicableToScore() {

        if (players) {
            return !players.bothPlayersHaveMininumScoreForDeuce() &&
                    players.bothPlayersHaveScoredMoreThanOrEqualsToPoints(0)
        }

        return !BothPlayersPreconditions.bothPlayersHaveMininumScoreForDeuce(player1Points, player2Points) &&
                BothPlayersPreconditions.bothPlayersHaveScoreAtLeast(player1Points, player2Points, 0)
    }

    String displaySpecificScore() {
        if (players) {
            return players.withPlayersPoints { Integer p1, Integer p2 ->
                "${calculateScoreForPoints(p1)}-${calculateScoreForPoints(p2)}"
            }
        }
        return "${calculateScoreForPoints(player1Points)}-${calculateScoreForPoints(player2Points)}"
    }

    private int calculateScoreForPoints(int p) {
        (p * 15) - (5 * floor(p/3))
    }
}
