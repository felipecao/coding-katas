package au.com.dius.tennis.random

import org.apache.commons.lang3.RandomUtils

class RandomIntegerLessThan50 {

    private static final int UPPER_THRESHOLD = 50

    static int greaterThan(int minimumThreshold) {
        RandomUtils.nextInt(minimumThreshold + 1, UPPER_THRESHOLD)
    }

    static int lessThan(int maximumThreshold) {
        RandomUtils.nextInt(0, maximumThreshold)
    }
}
