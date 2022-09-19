package com.java.jpp.javalgebra;

import com.java.jpp.javalgebra.mengen.EndlicheMenge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Abbildung<T,S> {

    List<S> elements;
    Menge<T> definition;
    Menge<S> ziel;
    Function<T, S> transform;

    public Abbildung(Menge<T> definitionsmenge, Menge<S> zielmenge, Function<T, S> abbVorschrift) {
        if (!definitionsmenge.getSize().isPresent() || !zielmenge.getSize().isPresent())
            throw new IllegalArgumentException("Infinite Set not allowed!");

        this.definition = definitionsmenge;
        this.ziel = zielmenge;
        this.transform = abbVorschrift;

        elements = definitionsmenge
                .getElements()
                .map(abbVorschrift)
                .collect(Collectors.toList());

        if (elements.stream().anyMatch(e -> !zielmenge.contains(e)))
            throw new IllegalArgumentException("Element not in target Set");
    }


    public S apply(T t) {
        if (!definition.contains(t))
            throw new IllegalArgumentException("Element not in target Set");

        return transform.apply(t);
    }

    public Menge<S> getBildVon(Menge<T> m) {
        if (!m.getElements().allMatch(e -> definition.contains(e))) {
            throw new IllegalArgumentException("Not a SubSet");
        }

        Set<S> elementSet = m.getElements().map(transform).collect(Collectors.toSet());

        return new EndlicheMenge<>(elementSet);
    }

    public Menge<T> getUrbildVon(Menge<S> m) {
        if (!m.getElements().allMatch(e -> ziel.contains(e))) {
            throw new IllegalArgumentException("Not a SubSet");
        }

        Set<T> elementSet = definition
                .getElements()
                .filter(e -> m.contains(apply(e)))
                .collect(Collectors.toSet());

        return new EndlicheMenge<>(elementSet);
    }

    public boolean isInjektiv() {
        List<S> elementList = definition.getElements().map(transform).collect(Collectors.toList());

        return elementList.size() == new HashSet<>(elementList).size();
    }

    public boolean isSurjektiv() {
        List<S> zielElements = ziel.getElements().toList();
        for(S elem: zielElements){
            if (!elements.contains(elem))
                return false;
        }
        return true;
    }

    public boolean isBijektiv() {
        return isInjektiv() && isSurjektiv();
    }

    public Abbildung<S, T> getUmkehrabbildung() {
        if (!isBijektiv())
            throw new UnsupportedOperationException("Abbildung not bijektiv");
        return new Abbildung<S, T>(ziel,definition, (Function<S, T>) transform);
    }
}
