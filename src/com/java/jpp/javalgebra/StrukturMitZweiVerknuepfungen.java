package com.java.jpp.javalgebra;

public class StrukturMitZweiVerknuepfungen<T> {

    public StrukturMitZweiVerknuepfungen(Menge<T> menge, Abbildung<Tupel<T>,T> plus, Abbildung<Tupel<T>,T> mal) {
        throw new UnsupportedOperationException();
    }

    public T applyPlus(T t1, T t2) {
        throw new UnsupportedOperationException();
    }

    public T applyMal(T t1, T t2) {
        throw new UnsupportedOperationException();
    }

    public boolean isDistributiv() {
        throw new UnsupportedOperationException();
    }

    public boolean isRing() {
        throw new UnsupportedOperationException();
    }

    public T getNull() {
        throw new UnsupportedOperationException();
    }

    public boolean isKoerper() {
        throw new UnsupportedOperationException();
    }

    public T getEins() {
        throw new UnsupportedOperationException();
    }
}
