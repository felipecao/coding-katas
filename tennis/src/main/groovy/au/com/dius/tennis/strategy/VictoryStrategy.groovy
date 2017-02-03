package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players

import static org.apache.commons.lang3.StringUtils.EMPTY

class VictoryStrategy extends AbstractStrategy {

    public static final String VICTORY = "wins"

    VictoryStrategy(Players p) {
        this.players = p
    }

    boolean isApplicableToScore() {
        return players.anyPlayerHasScoredMoreThanOrEqualsToPoints(4) &&
                players.differenceInPointsIsGreaterThanOrEqualsTo(2)
    }

    String displaySpecificScore() {
        return players.withAdvantagePlayerName { String winner ->
            "$winner $VICTORY"
        }
    }

    @Override
    String winner() {
        if (!isApplicableToScore()) {
            return EMPTY
        }

        return players.withAdvantagePlayerName { String winner ->
            winner
        }
    }
}
