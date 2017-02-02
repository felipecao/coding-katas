package au.com.dius.tennis.strategy

import static org.apache.commons.lang3.StringUtils.EMPTY

class VoidStrategy extends AbstractStrategy {

    VoidStrategy(Map<String, Integer> playersNamesAndPoints) {
        initializePlayersNamesAndPoints(playersNamesAndPoints)
    }

    boolean isApplicableToScore() {
        true
    }

    String displaySpecificScore() {
        return EMPTY
    }
}
