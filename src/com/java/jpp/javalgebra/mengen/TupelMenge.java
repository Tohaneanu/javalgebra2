package com.java.jpp.javalgebra.mengen;

import com.java.jpp.javalgebra.Menge;
import com.java.jpp.javalgebra.Tupel;

import java.util.Optional;
import java.util.stream.Stream;

public class TupelMenge<T> implements Menge<Tupel<T>> {

    public TupelMenge(Menge<T> menge) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<Tupel<T>> getElements() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Tupel<T> element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Integer> getSize() {
        throw new UnsupportedOperationException();
    }
}
