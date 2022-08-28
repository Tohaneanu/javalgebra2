package com.java.jpp.javalgebra;

import com.java.jpp.javalgebra.mengen.RestklassenMenge;

public class AlgebraRestklassenMenge {

    public static void main(String[] args) {
        AlgebraRestklassenMenge algebra = new AlgebraRestklassenMenge();

        algebra.restSet();
    }

    private void restSet() {
        RestklassenMenge rest = new RestklassenMenge(5);

        System.out.println("Contains 3: " + rest.contains(3));
        System.out.println("Contains -2: " + rest.contains(-2));
        System.out.println("Size: " + rest.getSize().get());

        try {
            RestklassenMenge rest2 = new RestklassenMenge(-3);
        } catch (Exception e) {
            System.out.println("-3 Error: " + e.getMessage());
        }

        try {
            RestklassenMenge rest3 = new RestklassenMenge(0);
        } catch (Exception e) {
            System.out.println("0 Error: " + e.getMessage());
        }

        RestklassenMenge rest4 = new RestklassenMenge(3);
        System.out.println("Rest 3: " + rest4.asString());

    }
}
