package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players

import static org.apache.commons.lang3.StringUtils.EMPTY
import static java.lang.Math.abs

class VictoryStrategy extends AbstractStrategy {

    public static final String VICTORY = "wins"

    VictoryStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    VictoryStrategy(Players p) {
        this.players = p
    }

    boolean isApplicableToScore() {
        if (players) {
            return players.anyPlayerHasScoredMoreThanOrEqualsToPoints(4) &&
                    players.differenceInPointsIsGreaterThanOrEqualsTo(2)
        }

        (player1Points >= 4 || player2Points >= 4) && abs(pointsDifference) >= 2
    }

    String displaySpecificScore() {
        if (players) {
            return players.withAdvantagePlayerName { String winner ->
                "$winner $VICTORY"
            }
        }

        "${player1Points - player2Points > 0 ? player1Name : player2Name} $VICTORY"
    }

    @Override
    String winner() {
        if (!isApplicableToScore()) {
            return EMPTY
        }

        if (players) {
            return players.withAdvantagePlayerName { String winner ->
                winner
            }
        }

        player1Points - player2Points > 0 ? player1Name : player2Name
    }
}
