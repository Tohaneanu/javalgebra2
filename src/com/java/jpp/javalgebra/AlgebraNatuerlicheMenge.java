package com.java.jpp.javalgebra;

import com.java.jpp.javalgebra.mengen.NatuerlicheZahlen;

import java.math.BigInteger;

public class AlgebraNatuerlicheMenge {

    public static void main(String[] args) {
        AlgebraNatuerlicheMenge algebra = new AlgebraNatuerlicheMenge();

        algebra.naturalSet();
    }

    private void naturalSet() {
        NatuerlicheZahlen zahlen = new NatuerlicheZahlen();

        System.out.println("Contains -2: " + zahlen.contains(BigInteger.valueOf(-2)));
        System.out.println("Contains 0: " + zahlen.contains(BigInteger.valueOf(0)));
        System.out.println("Contains 16: " + zahlen.contains(BigInteger.valueOf(16)));
        if (zahlen.getSize().isPresent())
            System.out.println("Not empty!!!");
        else
            System.out.println("Optional empty!");
        System.out.println("Empty: " + zahlen.isEmpty());


        System.out.println("As String: " + zahlen.asString());
        System.out.println("As String 5 : " + zahlen.asString(5));

    }
}
