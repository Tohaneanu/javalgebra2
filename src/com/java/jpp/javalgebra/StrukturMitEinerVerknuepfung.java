package com.java.jpp.javalgebra;

import java.util.*;

public class StrukturMitEinerVerknuepfung<T> {

    Menge<T> menge;
    Abbildung<Tupel<T>, T> verknuepfung;

    public StrukturMitEinerVerknuepfung(Menge<T> menge, Abbildung<Tupel<T>, T> verknuepfung) {
        if (!menge.getSize().isPresent())
            throw new IllegalArgumentException("Infinite Set not allowed!");
        List<T> elements = menge.getElements().toList();
        for (T t1 : elements)
            for (T t2 : elements)
                if (!menge.contains(verknuepfung.apply(new Tupel<>(t1, t2))))
                    throw new IllegalArgumentException("map value is not in menge!");
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
                    if (verknuepfung.apply(new Tupel<>(verknuepfung.apply(new Tupel<>(elem1, elem2)), elem3)) != verknuepfung.apply(new Tupel<>(elem1, verknuepfung.apply(new Tupel<>(elem2, elem3)))))
                        return false;
                }
        return true;
    }

    public boolean isMonoid() {
        List<T> mengeElements = menge.getElements().toList();
        if (!isHalbgruppe())
            return false;
        for (int i = 0; i < mengeElements.size(); i++) {
            for (int j = 0; j < mengeElements.size(); j++) {
                if (j == i)
                    continue;
                if (verknuepfung.apply(new Tupel<>(mengeElements.get(i), mengeElements.get(j))).equals(verknuepfung.apply(new Tupel<>(mengeElements.get(j), mengeElements.get(i)))) && verknuepfung.apply(new Tupel<>(mengeElements.get(i), mengeElements.get(j))).equals(mengeElements.get(i)))
                    return true;
            }
        }
        return false;
    }

    public T getNeutralesElement() {
        List<T> mengeElements = menge.getElements().toList();
        if (!isMonoid())
            throw new UnsupportedOperationException("the structure is not a monoid!");
        HashMap<T, Integer> result = new HashMap<T, Integer>();
        for (int i = 0; i < mengeElements.size(); i++) {
            for (int j = 0; j < mengeElements.size(); j++) {
                if (j == i)
                    continue;
                if (verknuepfung.apply(new Tupel<>(mengeElements.get(i), mengeElements.get(j))).equals(verknuepfung.apply(new Tupel<>(mengeElements.get(j), mengeElements.get(i)))) && verknuepfung.apply(new Tupel<>(mengeElements.get(i), mengeElements.get(j))).equals(mengeElements.get(i))) {
                    if (result.containsKey(mengeElements.get(j)))
                        result.put(mengeElements.get(j), result.get(mengeElements.get(j)) + 1);
                    else
                        result.put(mengeElements.get(j), 0);
                }
            }
        }
        result = sortByValue(result);
        return result.keySet().stream().toList().get(0);
    }

    public HashMap<T, Integer>
    sortByValue(HashMap<T, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<T, Integer>> list
                = new LinkedList<Map.Entry<T, Integer>>(
                hm.entrySet());

        // Sort the list using lambda expression
        Collections.sort(
                list,
                (i1,
                 i2) -> i2.getValue().compareTo(i1.getValue()));

        // put data from sorted list to hashmap
        HashMap<T, Integer> temp
                = new LinkedHashMap<T, Integer>();
        for (Map.Entry<T, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public boolean isGruppe() {
        if (!isMonoid())
            return false;
        T neutralElem = getNeutralesElement();
        List<T> mengeElements = menge.getElements().toList();
        boolean isInvers;
        for (int i = 0; i < mengeElements.size(); i++) {
            if (mengeElements.get(i)==neutralElem){
                continue;
            }
            isInvers = false;
            for (int j = 0; j < mengeElements.size(); j++) {
                if (j == i)
                    continue;
                if (verknuepfung.apply(new Tupel<>(mengeElements.get(i), mengeElements.get(j))).equals(verknuepfung.apply(new Tupel<>(mengeElements.get(j), mengeElements.get(i)))) && verknuepfung.apply(new Tupel<>(mengeElements.get(i), mengeElements.get(j))).equals(neutralElem)) {
                    isInvers = true;
                }
            }
            if (!isInvers)
                return false;
        }
        return true;
    }

    public boolean isKommutativ() {
        List<T> mengeElements = menge.getElements().toList();
        for (T elem1 : mengeElements)
            for (T elem2 : mengeElements) {
                if (verknuepfung.apply(new Tupel<>(elem1, elem2)) != verknuepfung.apply(new Tupel<>(elem2, elem1)))
                    return false;
            }
        return true;
    }

    public boolean isAbelscheGruppe() {
        if (isKommutativ() && isGruppe())
            return true;
        return false;

    }
}
