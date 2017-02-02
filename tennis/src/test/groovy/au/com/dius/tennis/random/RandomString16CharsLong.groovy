package au.com.dius.tennis.random

import org.apache.commons.lang3.RandomStringUtils

class RandomString16CharsLong {

    public static final int THRESHOLD = 16

    static String get() {
        RandomStringUtils.randomAlphanumeric(THRESHOLD)
    }
}
