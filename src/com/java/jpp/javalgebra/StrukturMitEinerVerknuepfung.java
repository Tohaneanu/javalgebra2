package com.java.jpp.javalgebra;

import java.util.List;

public class StrukturMitEinerVerknuepfung<T> {

    Menge<T> menge;
    Abbildung<Tupel<T>, T> verknuepfung;

    public StrukturMitEinerVerknuepfung(Menge<T> menge, Abbildung<Tupel<T>, T> verknuepfung) {
        if (!menge.getSize().isPresent())
            throw new IllegalArgumentException("Infinite Set not allowed!");
        List<T> elements = menge.getElements().toList();
        for (T t1 : elements)
            for (T t2 : elements)
                verknuepfung.apply(new Tupel<>(t1, t2));
        this.menge = menge;
        this.verknuepfung = verknuepfung;
    }

    public T apply(T t1, T t2) {
        if (!menge.contains(t1) || !menge.contains(t2))
            throw new IllegalArgumentException("Argument not in Set");

        return verknuepfung.apply(new Tupel<>(t1, t2));
    }

    public boolean isHalbgruppe() {
        List<T> mengeElements = menge.getElements().toList();
        for (T elem1 : mengeElements)
            for (T elem2 : mengeElements)
                for (T elem3 : mengeElements) {
                    if (verknuepfung.apply(new Tupel<>(verknuepfung.apply(new Tupel<>(elem1, elem2)), elem3)) != verknuepfung.apply(new Tupel<>(elem1,verknuepfung.apply(new Tupel<>(elem2, elem3)))))
                        return false;
                }
        return true;
    }

    public boolean isMonoid() {
        List<T> mengeElements = menge.getElements().toList();
        if (!isHalbgruppe())
            return false;
        for (T elem1 : mengeElements)
            for (T elem2 : mengeElements){
                if (verknuepfung.apply(new Tupel<>(elem1, elem2))==verknuepfung.apply(new Tupel<>(elem2, elem1)) && verknuepfung.apply(new Tupel<>(elem2, elem1))==elem1)
                    return true;
            }
        return false;
    }

    public T getNeutralesElement() {
        List<T> mengeElements = menge.getElements().toList();
        if(!isMonoid())
            throw new UnsupportedOperationException("the structure is not a monoid!");
        for (T elem1 : mengeElements)
            for (T elem2 : mengeElements){
                if (verknuepfung.apply(new Tupel<>(elem1, elem2))==verknuepfung.apply(new Tupel<>(elem2, elem1)) && verknuepfung.apply(new Tupel<>(elem2, elem1))==elem1)
                    return elem1;
            }
        throw new UnsupportedOperationException("element not found");
    }

    public boolean isGruppe() {
     if (!isMonoid())
         return false;
     return true;
    }

    public boolean isKommutativ() {
        List<T> mengeElements = menge.getElements().toList();
        for (T elem1 : mengeElements)
            for (T elem2 : mengeElements){
                if (verknuepfung.apply(new Tupel<>(elem1, elem2))!=verknuepfung.apply(new Tupel<>(elem2, elem1)))
                    return false;
            }
        return true;
    }

    public boolean isAbelscheGruppe() {
       if (isKommutativ())
           return true;
       return false;

    }
}
