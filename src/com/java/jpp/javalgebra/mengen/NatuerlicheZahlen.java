package com.java.jpp.javalgebra.mengen;

import com.java.jpp.javalgebra.Menge;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

public class NatuerlicheZahlen implements Menge<BigInteger> {

    @Override
    public Stream<BigInteger> getElements() {
        return Stream.iterate(BigInteger.ONE, i -> i.add(BigInteger.ONE));
    }


    @Override
    public boolean contains(BigInteger element) {
        return element.intValue() > 0;
    }

    @Override
    public Optional<Integer> getSize() {
        return Optional.empty();
    }
}
