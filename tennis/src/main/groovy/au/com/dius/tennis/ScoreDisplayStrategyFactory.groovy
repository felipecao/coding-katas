package au.com.dius.tennis

import au.com.dius.tennis.ScoreDisplayStrategy
import au.com.dius.tennis.strategy.AdvantageStrategy
import au.com.dius.tennis.strategy.DeuceStrategy
import au.com.dius.tennis.strategy.RegularScoreStrategy
import au.com.dius.tennis.strategy.VictoryStrategy
import au.com.dius.tennis.strategy.VoidStrategy

class ScoreDisplayStrategyFactory {

    static ScoreDisplayStrategy buildForNamesAndPoints(Map<String, Integer> namesAndPoints) {
        [
                new VictoryStrategy(namesAndPoints),
                new AdvantageStrategy(namesAndPoints),
                new DeuceStrategy(namesAndPoints),
                new RegularScoreStrategy(namesAndPoints),
                new VoidStrategy(namesAndPoints)
        ].find {it.applicableToScore}
    }
}
