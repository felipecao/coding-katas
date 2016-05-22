package stockbroker.useCase

class SummarizeStocks {

    static final String SUMMARY_REPORT_FORMAT = "Buy: %d Sell: %d"
    static final String SUMMARY_REPORT_WITH_ERROR_FORMAT = "${SUMMARY_REPORT_FORMAT}; Badly formed %d: %s"

    private Orders orders

    SummarizeStocks(Orders orders) {
        this.orders = orders
    }

    String execute(String transactions) {

        orders.importFromInput(transactions)

        Integer totalBought = orders.totalBoughtOrders()
        Integer totalSold = orders.totalSoldOrders()
        List invalidOrders = orders.invalidOrders

        if (invalidOrders) { // TODO can we use polyporphism somehow here?!
            return reportStocksSummary(totalBought, totalSold, invalidOrders)
        }

        return reportStocksSummary(totalBought, totalSold)
    }

    private String reportStocksSummary(Integer bought, Integer sold) {
        return String.format(SUMMARY_REPORT_FORMAT, bought, sold)
    }

    private String reportStocksSummary(Integer bought, Integer sold, List stocksWithErrors) {
        return String.format(SUMMARY_REPORT_WITH_ERROR_FORMAT, bought, sold, stocksWithErrors.size(), stocksWithErrors.join("; "))
    }
}
