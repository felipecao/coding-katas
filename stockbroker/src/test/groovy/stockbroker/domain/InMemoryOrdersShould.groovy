package stockbroker.domain

import spock.lang.Specification
import stockbroker.inputHandler.OrderStringParser
import stockbroker.useCase.Orders

class InMemoryOrdersShould extends Specification {

    Orders orders
    OrderParser parser

    def setup() {
        parser = new OrderStringParser() // TODO should be a mock, no?
        orders = new InMemoryOrders(parser)
    }

    def "be empty when importing null input"() {
        given:
        String input = null

        when:
        orders.importFromInput(input)

        then:
        0 == orders.totalBoughtOrders()
        0 == orders.totalSoldOrders()
        orders.invalidOrders.isEmpty()
    }

    def "not be empty when importing empty input"() {
        given:
        String input = " "

        when:
        orders.importFromInput(input)

        then:
        0 == orders.totalBoughtOrders()
        0 == orders.totalSoldOrders()
        [input] == orders.invalidOrders
    }

    def 'have 100 as total bought order when we import an order to buy 10 units of a $10 order'() {
        given:
        String input = "ZNGA 10 10.0 B"

        when:
        orders.importFromInput(input)

        then:
        100 == orders.totalBoughtOrders()
        0 == orders.totalSoldOrders()
        orders.invalidOrders.isEmpty()
    }

    def 'have 200 as total bought order when we import an order to buy 20 units of a $10 order'() {
        given:
        String input = "ZNGA 20 10.0 B"

        when:
        orders.importFromInput(input)

        then:
        200 == orders.totalBoughtOrders()
        0 == orders.totalSoldOrders()
        orders.invalidOrders.isEmpty()
    }

    def 'have 100 as total sold order when we import an order to sell 10 units of a $10 order'() {
        given:
        String input = "ZNGA 10 10.0 S"

        when:
        orders.importFromInput(input)

        then:
        0 == orders.totalBoughtOrders()
        100 == orders.totalSoldOrders()
        orders.invalidOrders.isEmpty()
    }

    def 'have 300 as total sold order when we import an order to sell 30 units of a $10 order'() {
        given:
        String input = "ZNGA 30 10.0 S"

        when:
        orders.importFromInput(input)

        then:
        0 == orders.totalBoughtOrders()
        300 == orders.totalSoldOrders()
        orders.invalidOrders.isEmpty()
    }

    def 'have 600 as total sold order when we import an order to sell 30 units of a $20 order'() {
        given:
        String input = "ZNGA 30 20.0 S"

        when:
        orders.importFromInput(input)

        then:
        0 == orders.totalBoughtOrders()
        600 == orders.totalSoldOrders()
        orders.invalidOrders.isEmpty()
    }

    def 'have no totals and one invalid order when importing an invalid order'() {
        given:
        String input = "ZNGA 30 20.0 "

        when:
        orders.importFromInput(input)

        then:
        0 == orders.totalBoughtOrders()
        0 == orders.totalSoldOrders()
        [input] == orders.invalidOrders
    }

    def 'have no totals and two invalid orders when importing two invalid orders'() {
        given:
        String input = "ZNGA 30 20.0,ZNGA 30 20.0 "

        when:
        orders.importFromInput(input)

        then:
        0 == orders.totalBoughtOrders()
        0 == orders.totalSoldOrders()
        ["ZNGA 30 20.0", "ZNGA 30 20.0 "] == orders.invalidOrders
    }

    def 'have 200 total bought and one invalid order'() {
        given:
        String input = "ZNGA 10 20.0 B,ZNGA 30 20.0 "

        when:
        orders.importFromInput(input)

        then:
        200 == orders.totalBoughtOrders()
        0 == orders.totalSoldOrders()
        ["ZNGA 30 20.0 "] == orders.invalidOrders
    }

    def 'have 200 total sold and one invalid order'() {
        given:
        String input = "ZNGA 10 20.0 S,ZNGA 30 20.0 "

        when:
        orders.importFromInput(input)

        then:
        0 == orders.totalBoughtOrders()
        200 == orders.totalSoldOrders()
        ["ZNGA 30 20.0 "] == orders.invalidOrders
    }

    def 'have 200 total sold, 400 total bought and one invalid order'() {
        given:
        String input = "ZNGA 10 20.0 S,ZNGA 10 40.0 B,ABCD 50 70.0 "

        when:
        orders.importFromInput(input)

        then:
        400 == orders.totalBoughtOrders()
        200 == orders.totalSoldOrders()
        ["ABCD 50 70.0 "] == orders.invalidOrders
    }

    def 'have 200 total sold, 400 total bought and two invalid orders'() {
        given:
        String input = "ZNGA 10 20.0 S,ZNGA 10 40.0 B,ABCD 50 70.0 ,CDEF 50 70 B"

        when:
        orders.importFromInput(input)

        then:
        400 == orders.totalBoughtOrders()
        200 == orders.totalSoldOrders()
        ["ABCD 50 70.0 ", "CDEF 50 70 B"] == orders.invalidOrders
    }

}
