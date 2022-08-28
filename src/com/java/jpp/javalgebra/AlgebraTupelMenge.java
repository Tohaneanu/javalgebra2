package com.java.jpp.javalgebra;

import com.java.jpp.javalgebra.mengen.NatuerlicheZahlen;
import com.java.jpp.javalgebra.mengen.RestklassenMenge;
import com.java.jpp.javalgebra.mengen.TupelMenge;

public class AlgebraTupelMenge {

    public static void main(String[] args) {
        AlgebraTupelMenge algebra = new AlgebraTupelMenge();

        algebra.tupelSet();
    }

    private void tupelSet() {
        TupelMenge tupel;

        try {
            tupel = new TupelMenge(new NatuerlicheZahlen());
        } catch (Exception e) {
            System.out.println("Natural Numbers: " + e.getMessage());
        }

        tupel = new TupelMenge<>(new RestklassenMenge(3));
        System.out.println("Tupel 3 as String: " + tupel.asString());

        tupel = new TupelMenge<>(new RestklassenMenge(4));
        System.out.println("Tupel 4 Size: " + tupel.getSize());
        System.out.println("Tupel 4 Contains (2,3): " + tupel.contains(new Tupel(2, 3)));
        System.out.println("Tupel 4 Contains (2,4): " + tupel.contains(new Tupel(2, 4)));


    }
}
