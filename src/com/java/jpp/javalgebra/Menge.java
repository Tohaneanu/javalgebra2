package com.java.jpp.javalgebra;

import java.util.Optional;
import java.util.stream.Stream;

public interface Menge<T> {

    Stream<T> getElements();

    default boolean contains(T element) {
        throw new UnsupportedOperationException();
    }

    default Optional<Integer> getSize() {
        throw new UnsupportedOperationException();
    }

    default boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    default String asString(int maxDisplay) {
        throw new UnsupportedOperationException();
    }

    default String asString() {
        throw new UnsupportedOperationException();
    }
}
