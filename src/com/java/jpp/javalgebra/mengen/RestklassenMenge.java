package com.java.jpp.javalgebra.mengen;

import com.java.jpp.javalgebra.Menge;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RestklassenMenge implements Menge<Integer> {
    private List<Integer> elements;
    private int mod;

    public RestklassenMenge(int mod) {
        if (mod < 1)
            throw new IllegalArgumentException("Input not a positive value");

        this.mod = mod;

        elements = IntStream
                .range(0, mod)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public Stream<Integer> getElements() {
        Collections.shuffle(elements);
        return elements.stream();
    }

    @Override
    public boolean contains(Integer element) {
        return (element >= 0 && element < mod);
    }

    @Override
    public Optional<Integer> getSize() {
        return Optional.of(mod);
    }
}