package com.java.jpp.javalgebra;

import java.util.Optional;
import java.util.stream.Stream;

public interface Menge<T> {
    Stream<T> getElements();

    default boolean contains(T element) {
        return getElements().anyMatch(e -> e.equals(element));
    }

    default Optional<Integer> getSize() {
        Long count = getElements().count();
        return Optional.of(count.intValue());
    }

    default boolean isEmpty() {
        if (getSize().isPresent()) {
            return getSize().get() == 0;
        } else {
            return false;
        }
    }

    default String asString(int maxDisplay) {
        if (maxDisplay < 1)
            throw new IllegalArgumentException("invalid value maxDisplay=" + maxDisplay);
        if (isEmpty())
            return "[]";

        StringBuilder builder = new StringBuilder("[");

        getElements()
                .map(Object::toString)
                .limit(maxDisplay)
                .forEach(e -> builder
                        .append(e)
                        .append(", "));

        int stringSize = builder.length();
        builder.setLength(stringSize - 2);
        String elements = builder.toString() + ']';


        if (!getSize().isPresent() || getSize().get() > maxDisplay) {
            return elements.replace("]", ", ...]");
        }

        return elements;
    }

    default String asString() {
        if (getSize().isPresent()) {
            if (getSize().get() == 0)
                return asString(1);
            return asString(getSize().get());
        } else {
            return asString(10);
        }
    }
}
