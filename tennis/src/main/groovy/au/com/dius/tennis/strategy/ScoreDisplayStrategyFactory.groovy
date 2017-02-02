package au.com.dius.tennis.strategy

class ScoreDisplayStrategyFactory {

    static ScoreDisplayStrategy buildForNamesAndPoints(Map<String, Integer> namesAndPoints) {
        [
                new RegularScoreStrategy(namesAndPoints),
                new DeuceStrategy(namesAndPoints),
                new AdvantageStrategy(namesAndPoints),
                new VictoryStrategy(namesAndPoints),
                new VoidStrategy(namesAndPoints)
        ].find {it.applicableToScore}
    }
}
