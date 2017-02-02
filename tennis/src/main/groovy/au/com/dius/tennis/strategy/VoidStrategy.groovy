package au.com.dius.tennis.strategy

class VoidStrategy extends AbstractStrategy {

    VoidStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersPoints(playersNamesAndPoints)
    }

    boolean isApplicableToScore() {
        true
    }

    String displaySpecificScore() {
        return BLANK
    }
}