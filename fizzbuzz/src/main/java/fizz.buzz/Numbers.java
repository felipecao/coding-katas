package fizz.buzz;

import fizz.buzz.number.Number;

import java.util.SortedSet;

public interface Numbers {
    SortedSet<Number> fetch(Integer upperBoundary);
}
