package com.java.jpp.javalgebra.mengen;

import com.java.jpp.javalgebra.Menge;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

public class GanzeZahlen implements Menge<BigInteger> {

    @Override
    public Stream<BigInteger> getElements() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(BigInteger element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Integer> getSize() {
        throw new UnsupportedOperationException();
    }
}
