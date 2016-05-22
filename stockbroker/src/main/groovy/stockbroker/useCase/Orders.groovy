package stockbroker.useCase

interface Orders {

    Integer totalBoughtOrders() // TODO this should be an Amount! No primitives!
    Integer totalSoldOrders() // TODO this should be an Amount! No primitives!
    List getInvalidOrders()
    void importFromInput(String input) // TODO this should be an instance of UserInput! No Strings!

}
