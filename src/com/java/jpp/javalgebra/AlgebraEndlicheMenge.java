package com.java.jpp.javalgebra;

import com.java.jpp.javalgebra.mengen.EndlicheMenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class AlgebraEndlicheMenge {
    public static void main(String[] args) {
        AlgebraEndlicheMenge algebra = new AlgebraEndlicheMenge();

        algebra.finiteSet();
    }

    public void finiteSet() {
        EndlicheMenge<Integer> endlich = new EndlicheMenge<>(new HashSet<>(Arrays.asList(2, 65, -2354, 254)));

        System.out.println("Stream: " + endlich.getElements().collect(Collectors.toList()));
        System.out.println("Size: " + endlich.getSize().get());
        System.out.println("Empty: " + endlich.isEmpty());
        System.out.println("Contains 3: " + endlich.contains(3));
        System.out.println("As String: " + endlich.asString());
        System.out.println("As String 4: " + endlich.asString(4));
    }
}
