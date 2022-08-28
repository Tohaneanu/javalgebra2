package com.java.jpp.javalgebra;

import com.java.jpp.javalgebra.mengen.LeereMenge;

public class AlgebraMenge {

    public static void main(String[] args) {
        AlgebraMenge algebra = new AlgebraMenge();

        algebra.emptySet();
    }

    public void emptySet() {
        LeereMenge<Integer> leer = new LeereMenge<>();

        System.out.println("Contains 2: " + leer.contains(2));
        System.out.println("Contains 23: " + leer.contains(23));
        System.out.println("Size: " + leer.getSize().get());
        System.out.println("Empty: " + leer.isEmpty());
        System.out.println("As String 5: " + leer.asString(5));
        System.out.println("As String: " + leer.asString());


        try {
            System.out.println("Menge String: " + leer.asString(-4));
        } catch (Exception e) {
            System.out.println("Negative Argument Error: " + e.getMessage());
        }

        try {
            System.out.println("Menge String 0: " + leer.asString(0));
        } catch (Exception e) {
            System.out.println("0 Argument Error: " + e.getMessage());
        }
    }
}
