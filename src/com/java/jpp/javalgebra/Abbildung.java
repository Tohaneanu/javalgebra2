package com.java.jpp.javalgebra;

import java.util.function.Function;

public class Abbildung<T,S> {

    public Abbildung(Menge<T> definitionsmenge, Menge<S> zielmenge, Function<T,S> abbVorschrift) {
        throw new UnsupportedOperationException();
    }

    public S apply(T t) {
        throw new UnsupportedOperationException();
    }

    public Menge<S> getBildVon(Menge<T> m) {
        throw new UnsupportedOperationException();
    }

    public Menge<T> getUrbildVon(Menge<S> m) {
        throw new UnsupportedOperationException();
    }

    public boolean isInjektiv() {
        throw new UnsupportedOperationException();
    }

    public boolean isSurjektiv() {
        throw new UnsupportedOperationException();
    }

    public boolean isBijektiv() {
        throw new UnsupportedOperationException();
    }

    public Abbildung<S, T> getUmkehrabbildung() {
        throw new UnsupportedOperationException();
    }
}
