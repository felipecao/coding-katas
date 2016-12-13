package com.github.felipecao.katas.banking.domain

class Transactions {
    private List<Transaction> transactions = []

    void add(Transaction t) {
        transactions << t
    }

    int getTotal() {
        transactions.size()
    }

    boolean contains(Transaction t) {
        transactions.contains(t)
    }

    void forEach(Closure c) {
        transactions.each {
            c(it)
        }
    }
}
