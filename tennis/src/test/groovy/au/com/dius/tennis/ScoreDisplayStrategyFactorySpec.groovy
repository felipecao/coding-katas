package au.com.dius.tennis

import au.com.dius.tennis.random.RandomString16CharsLong
import au.com.dius.tennis.strategy.*
import spock.lang.Specification
import spock.lang.Unroll

import static au.com.dius.tennis.random.RandomIntegerLessThan50.lessThan

class ScoreDisplayStrategyFactorySpec extends Specification {

    @Unroll
    def "buildForNamesAndPoints should return an instance of #instance when player 1 scores #player1Points and player 2 scores #player2Points"() {
        given:
        Players players = new Players(
                new Player(RandomString16CharsLong.get(), player1Points),
                new Player(RandomString16CharsLong.get(), player2Points)
        )

        expect:
        ScoreDisplayStrategyFactory.buildForPlayers(players).class.isAssignableFrom(instance)

        where:
        player1Points  | player2Points  | instance
        lessThan(3)    | lessThan(3)    | RegularScoreStrategy
        3              | 3              | DeuceStrategy
        4              | 3              | AdvantageStrategy
        5              | 3              | VictoryStrategy
        4              | 0              | VictoryStrategy
        -1             | -1             | VoidStrategy
    }

}
