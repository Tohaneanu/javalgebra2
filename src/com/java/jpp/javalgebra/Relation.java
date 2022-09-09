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
        if (!menge.getSize().isPresent()) throw new IllegalArgumentException("Infinite Set not allowed!");

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
        return menge.contains(element.getFirst()) && menge.contains(element.getSecond()) && isInRelation.apply(element.getFirst(), element.getSecond());
    }

    public boolean isReflexiv() {
        return menge.getElements().allMatch(e -> isInRelation.apply(e, e));
    }


    public boolean isIrreflexiv() {
        return menge.getElements().noneMatch(e -> isInRelation.apply(e, e));
    }


    public boolean isSymmetrisch() {
        return getElements().allMatch(t -> isInRelation.apply(t.getFirst(), t.getSecond())) && getElements().allMatch(t -> isInRelation.apply(t.getSecond(), t.getFirst()));
    }

    public boolean isAsymmetrisch() {
        List<T> elements = menge.getElements().toList();
        for (T elem1 : elements)
            for (T elem2 : elements) {
                if (isInRelation.apply(elem1, elem2)) {
                    if (isInRelation.apply(elem2, elem1))
                        return false;
                }
            }
        return true;
    }

    public boolean isAntisymmetrisch() {
        List<T> elements = menge.getElements().toList();
        for (T elem1 : elements)
            for (T elem2 : elements) {
                if (isInRelation.apply(elem1, elem2) && isInRelation.apply(elem2, elem1)) {
                    if (elem1 != elem2)
                        return false;
                }
            }
        return true;
    }

    public boolean isTransitiv() {
        List<T> elements = menge.getElements().toList();
        for (int i = 0; i < elements.size(); i++) {
            for (int j = 0; j < elements.size(); j++) {
                if (j == i)
                    continue;
                if (isInRelation.apply(elements.get(i), elements.get(j))) {
                    for (int k = 0; k < elements.size(); k++) {
                        if (k == j)
                            continue;
                        if (isInRelation.apply(elements.get(j), elements.get(k))) {
                            if (!isInRelation.apply(elements.get(i), elements.get(k)))
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean isTotal() {
        List<T> elements = menge.getElements().toList();
        for (T elem1 : elements)
            for (T elem2 : elements) {
                if (isInRelation.apply(elem1, elem2) || isInRelation.apply(elem2, elem1)) {
                } else return false;
            }
        return true;
    }

    public Set<Set<T>> getAequivalenzklassen() {
        if (!isAequivalenzrelation()) throw new UnsupportedOperationException("Relation is not Equivalent");

        return new HashSet<>();
    }

    public boolean isAequivalenzrelation() {
        return (isReflexiv() && isSymmetrisch() && isTransitiv());
    }

    public boolean isTotalordnung() {
        return (isReflexiv() && isAntisymmetrisch() && isTransitiv() && isTotal());
    }

    public List<T> getElementsInOrder() {
        if (!isTotalordnung()) throw new UnsupportedOperationException("Not a Total Order");

        return menge.getElements().sorted((t1, t2) -> isInRelation.apply(t1, t2) ? -1 : 1).toList();
    }
}
