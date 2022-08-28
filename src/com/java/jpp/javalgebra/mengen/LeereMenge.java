package com.java.jpp.javalgebra.mengen;

import com.java.jpp.javalgebra.Menge;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class LeereMenge<T> implements Menge<T> {
    @Override
    public Stream<T> getElements() {
        return Stream.empty();
    }
}
