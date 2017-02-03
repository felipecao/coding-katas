package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players

class AdvantageStrategy extends AbstractStrategy {

    public static final String ADVANTAGE = "Advantage"
    private static final Integer POINTS_DIFFERENCE_FOR_ADVANTAGE = 1

    AdvantageStrategy(Players p) {
        this.players = p
    }

    boolean isApplicableToScore() {
        return players.bothHaveMininumScoreForDeuce() &&
                players.differenceInPointsIs(POINTS_DIFFERENCE_FOR_ADVANTAGE)
    }

    String displaySpecificScore() {
        return players.withNameOfPlayerCurrentlyWinning { String playerName ->
            "$ADVANTAGE $playerName"
        }
    }
}
