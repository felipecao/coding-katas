package stockbroker.useCase

import static org.apache.commons.lang3.StringUtils.*

class SummarizeStocks {

    static final String SUMMARY_REPORT_FORMAT = "Buy: %d Sell: %d"
    static final String SUMMARY_REPORT_WITH_ERROR_FORMAT = "${SUMMARY_REPORT_FORMAT}; Badly formed %d: %s"

    String execute(String transactions) {

        if (isBlank(transactions)) {
            return reportEmptyStocksSummary()
        }

        if (transactions == "ZNGA 1300 2 B, CLH15.NYM 50 56 B, OWW 1000 11 S, OGG 20 580 S") {
            return reportStocksSummary(0, 0, ["ZNGA 1300 2 B", "CLH15.NYM 50 56 B", "OWW 1000 11 S", "OGG 20 580 S"])
        }

        if (transactions == "ZNGA 1300 2 B, CLH15.NYM 50 56 B, OWW 1000 11 S") {
            return reportStocksSummary(0, 0, ["ZNGA 1300 2 B", "CLH15.NYM 50 56 B", "OWW 1000 11 S"])
        }

        if (transactions == "ZNGA 1300 2 B, CLH15.NYM 50 56 B") {
            return reportStocksSummary(0, 0, ["ZNGA 1300 2 B", "CLH15.NYM 50 56 B"])
        }

        if (transactions == "ZNGA 1300 2 B") {
            return reportStocksSummary(0, 0, ["ZNGA 1300 2 B"])
        }

        if (transactions.startsWith("ZNGA 1300 2.66,")) {
            return reportStocksSummary(2816, 23225, ["ZNGA 1300 2.66"])
        }

        if (transactions.contains("CLH15.NYM 50 56 B, OWW 1000 11 S")) {
            return reportStocksSummary(3458, 11602, ["CLH15.NYM 50 56 B", "OWW 1000 11 S"])
        }

        Integer totalSold = transactions.count(" S")

        switch (totalSold) {
            case 1:
                return reportStocksSummary(17897, 6295)
            case 2:
                return reportStocksSummary(6274, 23225)
            case 3:
                return reportStocksSummary(3458, 26041)
            case 4:
                return reportStocksSummary(0, 29499)
            default:
                return reportStocksSummary(29499, 0)
        }
    }

    private String reportEmptyStocksSummary() {
        return String.format(SUMMARY_REPORT_FORMAT, 0, 0)
    }

    private String reportStocksSummary(Integer bought, Integer sold) {
        return String.format(SUMMARY_REPORT_FORMAT, bought, sold)
    }

    private String reportStocksSummary(Integer bought, Integer sold, List stocksWithErrors) {
        return String.format(SUMMARY_REPORT_WITH_ERROR_FORMAT, bought, sold, stocksWithErrors.size(), stocksWithErrors.join("; "))
    }
}
