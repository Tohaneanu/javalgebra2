package com.java.jpp.javalgebra;

public class StrukturMitEinerVerknuepfung<T> {

    Menge<T> menge;
    Abbildung<Tupel<T>, T> verknuepfung;

    public StrukturMitEinerVerknuepfung(Menge<T> menge, Abbildung<Tupel<T>, T> verknuepfung) {
        if (!menge.getSize().isPresent())
            throw new IllegalArgumentException("Infinite Set not allowed!");

        this.menge = menge;
        this.verknuepfung = verknuepfung;
    }

    public T apply(T t1, T t2) {
        if (!menge.contains(t1) || !menge.contains(t2))
            throw new IllegalArgumentException("Argument not in Set");

        return verknuepfung.apply(new Tupel<>(t1, t2));
    }

    public boolean isHalbgruppe() {
        throw new UnsupportedOperationException();
    }

    public boolean isMonoid() {
        throw new UnsupportedOperationException();
    }

    public T getNeutralesElement() {
        throw new UnsupportedOperationException();
    }

    public boolean isGruppe() {
        throw new UnsupportedOperationException();
    }

    public boolean isKommutativ() { throw new UnsupportedOperationException(); }

    public boolean isAbelscheGruppe() {
        throw new UnsupportedOperationException();
    }
}
