package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players

import static java.lang.Math.floor

class RegularScoreStrategy extends AbstractStrategy {

    RegularScoreStrategy(Players p) {
        this.players = p
    }

    boolean isApplicableToScore() {
        return players.dontHaveMininumScoreForDeuce() &&
                players.haveBothScoredMoreThanOrEqualsToPoints(0)
    }

    String displaySpecificScore() {
        return players.withPlayersPoints { Integer p1, Integer p2 ->
            "${calculateScoreForPoints(p1)}-${calculateScoreForPoints(p2)}"
        }
    }

    private int calculateScoreForPoints(int p) {
        (p * 15) - (5 * floor(p/3))
    }
}
