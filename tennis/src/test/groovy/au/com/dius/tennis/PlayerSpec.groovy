package au.com.dius.tennis

import au.com.dius.tennis.random.RandomString16CharsLong
import spock.lang.Specification

import static au.com.dius.tennis.random.RandomIntegerLessThan50.greaterThan

class PlayerSpec extends Specification {

    private Player player

    def "a player's name is the same used in instantiation"() {
        given:
        String name = RandomString16CharsLong.get()

        when:
        player = new Player(name)

        then:
        name == player.name
    }

    def "a player starts with 0 points and every time it scores, it has more points"() {
        given:
        player = new Player(RandomString16CharsLong.get())

        and:
        totalScores.times {
            player.score()
        }

        expect:
        totalScores == player.points

        where:
        totalScores |_
        0 |_
        greaterThan(0) |_
    }

}
