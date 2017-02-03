package au.com.dius.tennis.strategy

import au.com.dius.tennis.Score

import static org.apache.commons.lang3.StringUtils.EMPTY

class VoidStrategy extends AbstractStrategy {

    VoidStrategy(Score s) {
    }

    boolean isApplicableToScore() {
        true
    }

    String displaySpecificScore() {
        return EMPTY
    }
}
