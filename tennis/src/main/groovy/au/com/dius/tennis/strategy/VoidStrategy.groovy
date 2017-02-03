package au.com.dius.tennis.strategy

import au.com.dius.tennis.Players

import static org.apache.commons.lang3.StringUtils.EMPTY

class VoidStrategy extends AbstractStrategy {

    VoidStrategy(Players players) {
    }

    boolean isApplicableToScore() {
        true
    }

    String displaySpecificScore() {
        return EMPTY
    }
}
