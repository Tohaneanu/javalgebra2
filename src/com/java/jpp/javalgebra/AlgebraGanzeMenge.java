package com.java.jpp.javalgebra;

import com.java.jpp.javalgebra.mengen.GanzeZahlen;

import java.math.BigInteger;

public class AlgebraGanzeMenge {

    public static void main(String[] args) {
        AlgebraGanzeMenge algebra = new AlgebraGanzeMenge();

        algebra.completeSet();
    }

    private void completeSet() {
        GanzeZahlen ganz = new GanzeZahlen();

        System.out.println("Contains -2: " + ganz.contains(BigInteger.valueOf(-2)));
        if (ganz.getSize().isPresent())
            System.out.println("Not empty!!!");
        else
            System.out.println("Optional empty! - OK");

        System.out.println("Empty: " + ganz.isEmpty());

        System.out.println("As String: " + ganz.asString());
        System.out.println("As String 5 : " + ganz.asString(5));
    }
}
