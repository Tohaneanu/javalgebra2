package com.java.jpp.javalgebra.mengen;

import com.java.jpp.javalgebra.Menge;

import java.util.Optional;
import java.util.stream.Stream;

public class RestklassenMenge implements Menge<Integer> {

    public RestklassenMenge(int mod) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<Integer> getElements() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Integer element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Integer> getSize() {
        throw new UnsupportedOperationException();
    }
}
