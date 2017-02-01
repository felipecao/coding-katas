package au.com.dius.tennis

import spock.lang.Specification

class AcceptanceTests extends Specification {

    private Game game

    private static final String FIRST_PLAYER = "player 1"
    private static final String SECOND_PLAYER = "player 2"

    def setup() {
        game = new Game(FIRST_PLAYER, SECOND_PLAYER)
    }

    def "When game starts score is 0-0 "() {
        expect:
        "0-0" == game.score()
    }

    def "When the first player scores for the first time, the new score is 15-0"() {
        when:
        game.pointWonBy(FIRST_PLAYER)

        then:
        "15-0" == game.score()
    }

    def "When the first player scores twice, the new score is 30-0"() {
        when:
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(FIRST_PLAYER)

        then:
        "30-0" == game.score()
    }

    def "When the first player scores three times, the new score is 40-0"() {
        when:
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(FIRST_PLAYER)
        game.pointWonBy(FIRST_PLAYER)

        then:
        "40-0" == game.score()
    }

    def "When the second player scores for the first time, the new score is 0-15"() {
        when:
        game.pointWonBy(SECOND_PLAYER)

        then:
        "0-15" == game.score()
    }

    def "When the second player scores twice, the new score is 0-30"() {
        when:
        game.pointWonBy(SECOND_PLAYER)
        game.pointWonBy(SECOND_PLAYER)

        then:
        "0-30" == game.score()
    }

}
