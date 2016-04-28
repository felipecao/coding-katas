package br.felipecao.kata.core.domain;

import br.felipecao.kata.core.support.Amount;
import org.apache.commons.lang3.builder.CompareToBuilder;

import java.time.LocalDate;

public class TransactionImpl implements Transaction, Comparable<Transaction> {

    // TODO too many attributes, should split!
    private LocalDate date;
    private Amount amount;
    private TransactionType type;

    TransactionImpl(LocalDate d, Amount a, TransactionType t) {
        date = d;
        amount = a;
        type = t;
    }

    @Override
    public Amount getAmount() {
        return amount;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public TransactionType getType() {
        return type;
    }

    @Override
    public int compareTo(Transaction other) {
        return new CompareToBuilder()
                .append(this.date, other.getDate())
                .toComparison();
    }
}
