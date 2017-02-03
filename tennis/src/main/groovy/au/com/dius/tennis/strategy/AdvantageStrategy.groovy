package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players

import static java.lang.Math.abs

class AdvantageStrategy extends AbstractStrategy {

    public static final String ADVANTAGE = "Advantage"

    AdvantageStrategy(Players p) {
        this.players = p
    }

    boolean isApplicableToScore() {
        return players.bothPlayersHaveMininumScoreForDeuce() &&
                players.differenceInPointsIs(1)
    }

    String displaySpecificScore() {
        return players.withAdvantagePlayerName { String playerName ->
            "$ADVANTAGE $playerName"
        }
    }
}
