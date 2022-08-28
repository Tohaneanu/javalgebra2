package com.java.jpp.javalgebra.mengen;

import com.java.jpp.javalgebra.Menge;
import com.java.jpp.javalgebra.Tupel;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TupelMenge<T> implements Menge<Tupel<T>> {

    Set<Tupel<T>> tuples = new HashSet<>();

    public TupelMenge(Menge<T> menge) {
        if (!menge.getSize().isPresent())
            throw new IllegalArgumentException("Infinite Set not allowed!");

        List<T> elementList = menge.getElements().collect(Collectors.toList());

        for (T m : elementList) {
            for (T n : elementList) {
                tuples.add(new Tupel<>(m, n));
            }
        }
    }

    @Override
    public Stream<Tupel<T>> getElements() {
        return tuples.stream();
    }

    @Override
    public boolean contains(Tupel<T> element) {
        return tuples.contains(element);
    }

    @Override
    public Optional<Integer> getSize() {
        return Optional.of(tuples.size());
    }
}
