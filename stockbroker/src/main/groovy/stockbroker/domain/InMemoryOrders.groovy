package stockbroker.domain

import stockbroker.useCase.Orders

import static org.apache.commons.lang3.StringUtils.isBlank

class InMemoryOrders implements Orders {

    Integer totalBought = 0
    Integer totalSold = 0
    List invalidOrders = []

    private OrderParser orderParser

    InMemoryOrders(OrderParser orderParser) {
        this.orderParser = orderParser
    }

    @Override
    Integer totalBoughtOrders() {
        return totalBought
    }

    @Override
    Integer totalSoldOrders() {
        return totalSold
    }

    @Override
    List getInvalidOrders() {
        return invalidOrders
    }

    @Override
    void importFromInput(String input) {
        input?.split(",").each { entry ->

            def parseResult = orderParser.parse(entry)

            if(parseResult.status == "failure") { // FIXME introduces coupling to string and internal representation of parsing result
                invalidOrders << entry
            }
            else {
                if (entry.endsWith("S")) {
                    totalSold += parseResult.totalOrderAmount
                }
                else {
                    totalBought += parseResult.totalOrderAmount
                }
            }
        }
    }
}
