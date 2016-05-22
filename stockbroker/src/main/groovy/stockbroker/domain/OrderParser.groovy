package stockbroker.domain

interface OrderParser {
    def parse(String userInput) // TODO this should be an instance of UserInput! No Strings!
}
