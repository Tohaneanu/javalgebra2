package com.java.jpp.javalgebra.mengen;

import com.java.jpp.javalgebra.Menge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EndlicheMenge<T> implements Menge<T> {

    private Set<T> elementSet;

    public EndlicheMenge(Set<T> objects) {
        elementSet = objects;
    }


    @Override
    public Stream<T> getElements() {
        List<T> elements = new ArrayList<>(elementSet);
        Collections.shuffle(elements);
        return elements.stream();
    }

    public EndlicheMenge<T> createUntermenge(Predicate<T> filter) {
        return new EndlicheMenge<>(elementSet.stream().filter(filter).collect(Collectors.toSet()));
    }
}
