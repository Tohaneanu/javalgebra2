package com.java.jpp.javalgebra;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class StrukturMitZweiVerknuepfungen<T> {
    private Menge<T> menge;
    private Abbildung<Tupel<T>, T> plus;
    private Abbildung<Tupel<T>, T> mal;

    public StrukturMitZweiVerknuepfungen(Menge<T> menge, Abbildung<Tupel<T>, T> plus, Abbildung<Tupel<T>, T> mal) {
        if (!menge.getSize().isPresent())
            throw new IllegalArgumentException("Infinite Set not allowed!");
//        if (plus.)
        List<T> elements = menge.getElements().toList();
        for (T t1 : elements)
            for (T t2 : elements)
                if (!menge.contains(plus.apply(new Tupel<>(t1, t2))) || !menge.contains(mal.apply(new Tupel<>(t1, t2))))
                    throw new IllegalArgumentException("map value is not in menge!");
        this.menge = menge;
        this.plus = plus;
        this.mal = mal;
    }

    public T applyPlus(T t1, T t2) {
        if (!menge.contains(t1) || !menge.contains(t2))
            throw new IllegalArgumentException("Argument not in Set");
        return plus.apply(new Tupel<>(t1, t2));
    }

    public T applyMal(T t1, T t2) {
        if (!menge.contains(t1) || !menge.contains(t2))
            throw new IllegalArgumentException("Argument not in Set");
        return mal.apply(new Tupel<>(t1, t2));
    }

    public boolean isDistributiv() {
        AtomicBoolean response = new AtomicBoolean(true);
        menge.getElements().forEach(elm1 -> menge.getElements()
                .forEach(elem2 -> menge.getElements()
                        .forEach(elem3 -> {
                            if (firstCheck(elm1, elem2, elem3) || secondCheck(elm1, elem2, elem3))
                                response.set(false);
                        })));
        return response.get();
    }

    private boolean firstCheck(T t1, T t2, T t3) {
        return mal.apply(new Tupel<>(t1, plus.apply(new Tupel<>(t2, t3)))) != plus.apply(new Tupel<>(mal.apply(new Tupel<>(t1, t2)), mal.apply(new Tupel<>(t1, t3))));
    }

    private boolean secondCheck(T t1, T t2, T t3) {
        return mal.apply(new Tupel<>(t1, plus.apply(new Tupel<>(t2, t3)))) != plus.apply(new Tupel<>(mal.apply(new Tupel<>(t1, t2)), mal.apply(new Tupel<>(t1, t3))));
    }

    public boolean isRing() {
        List<T> mengeElements = menge.getElements().toList();
        for (T elem1 : mengeElements)
            for (T elem2 : mengeElements) {
                if (plus.apply(new Tupel<>(elem1, elem2)) != plus.apply(new Tupel<>(elem2, elem1)))
                    return false;
                for (T elem3 : mengeElements) {
                    if (mal.apply(new Tupel<>(mal.apply(new Tupel<>(elem1, elem2)), elem3)) != mal.apply(new Tupel<>(elem1, mal.apply(new Tupel<>(elem2, elem3)))))
                        return false;
                }
            }
        if (isDistributiv())
            return true;
        else return false;
    }

    public T getNull() {
        if (!isRing())
            throw new UnsupportedOperationException("The structure is not a ring!");
        List<T> mengeElements = menge.getElements().toList();
        for (int i = 0; i < mengeElements.size(); i++) {
            for (int j = 0; j < mengeElements.size(); j++) {
                if (j == i)
                    continue;
                if (plus.apply(new Tupel<>(mengeElements.get(i), mengeElements.get(j))).equals(plus.apply(new Tupel<>(mengeElements.get(j), mengeElements.get(i)))) && plus.apply(new Tupel<>(mengeElements.get(i), mengeElements.get(j))).equals(mengeElements.get(i)))
                    return mengeElements.get(j);
            }
        }
        throw new UnsupportedOperationException("the structure is not a monoid!");
    }

    public boolean isKoerper() {
        if (!isRing())
            return false;
        List<T> mengeElements = menge.getElements().toList();
        T nElem = null;
        try {
            nElem = getNull();
        } catch (UnsupportedOperationException ignored) {

        }
        for (T elem1 : mengeElements)
            for (T elem2 : mengeElements) {
                {
                    if (nElem != null && (nElem == elem1 || nElem == elem2)) continue;
                    if (mal.apply(new Tupel<>(elem1, elem2)) != mal.apply(new Tupel<>(elem2, elem1)))
                        return false;
                }
            }
        return true;
    }

    public T getEins() {
        if (!isKoerper())
            throw new UnsupportedOperationException("The structure is not a Koerper!");
        List<T> mengeElements = menge.getElements().toList();
        for (int i = 0; i < mengeElements.size(); i++) {
            for (int j = 0; j < mengeElements.size(); j++) {
                if (i == j)
                    continue;
                if (plus.apply(new Tupel<>(mengeElements.get(i), mengeElements.get(j))) == plus.apply(new Tupel<>(mengeElements.get(j), mengeElements.get(i))) && plus.apply(new Tupel<>(mengeElements.get(i), mengeElements.get(j))) == mengeElements.get(i))
                    return mengeElements.get(j);
            }
        }
        throw new UnsupportedOperationException("dont find null element!");
    }
}
