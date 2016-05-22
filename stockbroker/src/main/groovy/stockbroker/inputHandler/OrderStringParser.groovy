package stockbroker.inputHandler

import stockbroker.domain.OrderParser

class OrderStringParser implements OrderParser {

    static final String USER_INPUT_FORMAT = /[A-Za-z0-9]+ [0-9]+ [0-9]+[.]+[0-9]+ (B|S)+/

    @Override
    def parse(String userInput) {

        if (inputIsInvalid(userInput)) {
            return [status: "failure"] // FIXME do not use map
        }

        Integer totalOrderAmount = calculateTotalOrderAmountFromInput(userInput)

        return [status: "success", totalOrderAmount: totalOrderAmount] // FIXME do not use map
    }

    private Boolean inputIsInvalid(String userInput) {
        return !(userInput =~ USER_INPUT_FORMAT)
    }

    private Integer calculateTotalOrderAmountFromInput(String userInput) {
        def orderParts = extractOrderPartsFromUserInput(userInput)
        return (orderParts.quantity * orderParts.price) as Integer
    }

    private def extractOrderPartsFromUserInput(String userInput) {
        String[] orderParts = userInput.split(" ")
        Integer quantity = Integer.valueOf(orderParts[1])
        Double price = Double.valueOf(orderParts[2])

        return [quantity: quantity, price: price]
    }
}
