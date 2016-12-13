package com.github.felipecao.katas.banking.support

class RandomAmount {
    static Amount get() {
        Amount.of(randomInt())
    }

    private static int randomInt() {
        new Random().nextInt(500)
    }
}
