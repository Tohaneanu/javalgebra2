package com.java.jpp.javalgebra.mengen;

import com.java.jpp.javalgebra.Menge;

import java.math.BigInteger;
import java.util.Optional;
import java.util.stream.Stream;

public class GanzeZahlen implements Menge<BigInteger> {
    @Override
    public Stream<BigInteger> getElements() {
        return Stream.iterate(BigInteger.ZERO, i -> {
            if (i.equals(BigInteger.ZERO))
                return i.add(BigInteger.ONE);

            if (i.signum() > 0)
                return i.negate();
            else
                return i.negate().add(BigInteger.ONE);
        });
    }

    @Override
    public boolean contains(BigInteger element) {
        return true;
    }

    @Override
    public Optional<Integer> getSize() {
        return Optional.empty();
    }
}
