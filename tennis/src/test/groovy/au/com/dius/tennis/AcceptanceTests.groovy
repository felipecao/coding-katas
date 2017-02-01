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

}
