package au.com.dius.tennis.strategy

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
