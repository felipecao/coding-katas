package au.com.dius.tennis.strategy

class ScoreCalculationStrategyFactory {

    static ScoreCalculationStrategy buildForNamesAndPoints(Map<String, Integer> namesAndPoints) {
        [
                new RegularScoreStrategy(namesAndPoints),
                new DeuceStrategy(namesAndPoints),
                new AdvantageStrategy(namesAndPoints),
                new VoidStrategy(namesAndPoints)
        ].find {it.applicableToScore}
    }
}
