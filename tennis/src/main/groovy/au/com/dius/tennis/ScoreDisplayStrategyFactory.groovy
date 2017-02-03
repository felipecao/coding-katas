package au.com.dius.tennis

import au.com.dius.tennis.strategy.*

class ScoreDisplayStrategyFactory {

    static ScoreDisplayStrategy buildForPlayers(Players players) {
        [
                new VictoryStrategy(players),
                new AdvantageStrategy(players),
                new DeuceStrategy(players),
                new RegularScoreStrategy(players),
                new VoidStrategy(players)
        ].find {it.applicableToScore}
    }
}
