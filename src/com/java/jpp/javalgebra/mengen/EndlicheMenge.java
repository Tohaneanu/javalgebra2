package com.java.jpp.javalgebra.mengen;

import com.java.jpp.javalgebra.Menge;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class EndlicheMenge<T> implements Menge<T> {

    public EndlicheMenge(Set<T> objects) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<T> getElements() {
        throw new UnsupportedOperationException();
    }

    public EndlicheMenge<T> createUntermenge(Predicate<T> filter) {
        throw new UnsupportedOperationException();
    }
}
