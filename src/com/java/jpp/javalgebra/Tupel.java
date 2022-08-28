package com.java.jpp.javalgebra;

import java.util.Objects;

public class Tupel<T> {

    private T first;
    private T second;

    public Tupel(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tupel<?> tupel = (Tupel<?>) o;
        return first.equals(tupel.first) && second.equals(tupel.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}