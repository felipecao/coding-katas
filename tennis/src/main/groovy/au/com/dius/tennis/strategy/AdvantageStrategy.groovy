package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players

import static java.lang.Math.abs

class AdvantageStrategy extends AbstractStrategy {

    public static final String ADVANTAGE = "Advantage"

    AdvantageStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    AdvantageStrategy(Players p) {
        this.players = p
    }

    boolean isApplicableToScore() {
        if (players) {
            return players.bothPlayersHaveMininumScoreForDeuce() &&
                    players.differenceInPointsIs(1)
        }

        BothPlayersPreconditions.bothPlayersHaveMininumScoreForDeuce(player1Points, player2Points) &&
            abs(pointsDifference) == 1
    }

    String displaySpecificScore() {
        if (players) {
            return players.withAdvantagePlayerName { String playerName ->
                "$ADVANTAGE $playerName"
            }
        }

        "$ADVANTAGE ${pointsDifference == 1 ? player1Name : player2Name}"
    }
}
