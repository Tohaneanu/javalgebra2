package com.java.jpp.javalgebra;

import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class Relation<T> implements Menge<Tupel<T>> {

    public Relation(Menge<T> menge, BiFunction<T,T,Boolean> isInRelation) {
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

    public boolean isReflexiv() {
        throw new UnsupportedOperationException();
    }

    public boolean isIrreflexiv() {
        throw new UnsupportedOperationException();
    }

    public boolean isSymmetrisch() {
        throw new UnsupportedOperationException();
    }

    public boolean isAsymmetrisch() {
        throw new UnsupportedOperationException();
    }

    public boolean isAntisymmetrisch() {
        throw new UnsupportedOperationException();
    }

    public boolean isTransitiv() {
        throw new UnsupportedOperationException();
    }

    public boolean isTotal() {
        throw new UnsupportedOperationException();
    }

    public boolean isAequivalenzrelation() {
        throw new UnsupportedOperationException();
    }

    public Set<Set<T>> getAequivalenzklassen() {
        throw new UnsupportedOperationException();
    }

    public boolean isTotalordnung() {
        throw new UnsupportedOperationException();
    }

    public List<T> getElementsInOrder() {
        throw new UnsupportedOperationException();
    }
}
