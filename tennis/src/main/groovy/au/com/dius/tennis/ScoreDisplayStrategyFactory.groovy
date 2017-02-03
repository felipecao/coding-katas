package au.com.dius.tennis

import au.com.dius.tennis.strategy.*

class ScoreDisplayStrategyFactory {

    static ScoreDisplayStrategy buildForPlayers(Score score) {
        [
                new VictoryStrategy(score),
                new AdvantageStrategy(score),
                new DeuceStrategy(score),
                new RegularScoreStrategy(score),
                new VoidStrategy(score)
        ].find {it.applicableToScore}
    }
}
