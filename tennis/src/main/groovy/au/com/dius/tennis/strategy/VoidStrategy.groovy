package au.com.dius.tennis.strategy

import static au.com.dius.tennis.lang.Strings.BLANK

class VoidStrategy extends AbstractStrategy {

    VoidStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    boolean isApplicableToScore() {
        true
    }

    String displaySpecificScore() {
        return BLANK
    }
}
