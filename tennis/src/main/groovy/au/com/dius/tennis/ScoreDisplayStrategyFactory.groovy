package au.com.dius.tennis

import au.com.dius.tennis.strategy.*

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
