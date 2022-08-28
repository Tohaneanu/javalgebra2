package com.java.jpp.javalgebra;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Relation<T> implements Menge<Tupel<T>> {
    Menge<T> menge;
    BiFunction<T, T, Boolean> isInRelation;
    Set<Tupel<T>> tuples = new HashSet<>();

    public Relation(Menge<T> menge, BiFunction<T, T, Boolean> isInRelation) {
        if (!menge.getSize().isPresent())
            throw new IllegalArgumentException("Infinite Set not allowed!");

        this.menge = menge;
        this.isInRelation = isInRelation;


        List<T> elementList = menge.getElements().collect(Collectors.toList());

        for (T m : elementList) {
            for (T n : elementList) {
                if (isInRelation.apply(m, n)) {
                    tuples.add(new Tupel<>(m, n));
                }
            }
        }
    }

    @Override
    public Stream<Tupel<T>> getElements() {
      return this.tuples.stream();
    }

    @Override
    public boolean contains(Tupel<T> element) {
        if (menge.contains(element.getFirst()) &&
                menge.contains(element.getSecond()) &&
                isInRelation.apply(element.getFirst(), element.getSecond()))
            return true;


        return false;
    }

    public boolean isReflexiv() {
        return menge.getElements().allMatch(e -> isInRelation.apply(e, e));
    }


    public boolean isIrreflexiv() {
        return menge.getElements().noneMatch(e -> isInRelation.apply(e, e));
    }


    public boolean isSymmetrisch() {
        return getElements().allMatch(t -> isInRelation.apply(t.getFirst(), t.getSecond())) &&
                getElements().allMatch(t -> isInRelation.apply(t.getSecond(), t.getFirst()));
    }

    public boolean isAsymmetrisch() {
        return getElements().allMatch(t -> isInRelation.apply(t.getFirst(), t.getSecond())) &&
                getElements().noneMatch(t -> isInRelation.apply(t.getSecond(), t.getFirst()));
    }

    public boolean isAntisymmetrisch() {
        return isSymmetrisch() && getElements().allMatch(t -> t.getFirst().equals(t.getSecond()));
    }

    public boolean isTransitiv() {
        throw new UnsupportedOperationException();
    }

    public boolean isTotal() {
        throw new UnsupportedOperationException();
    }

    public boolean isAequivalenzrelation() {
        return (isReflexiv() && isSymmetrisch() && isTransitiv());
    }

    public Set<Set<T>> getAequivalenzklassen() {
        if (!isAequivalenzrelation())
            throw new UnsupportedOperationException("Relation is not Equivalent");

        return null;
    }

    public boolean isTotalordnung() {
        return (isReflexiv() && isAntisymmetrisch() && isTransitiv() && isTotal());
    }

    public List<T> getElementsInOrder() {
        if (!isTotalordnung())
            throw new UnsupportedOperationException("Not a Total Order");

        return null;
    }
}
