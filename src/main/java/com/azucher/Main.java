package com.azucher;

import java.util.Arrays;

public class Main {
    private transient Integer age;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        String[] bugs = {"cricket", "beetle", "ladybug"};
        String[] alias = bugs;

        show("LALA", "LILI");
    }

    public static void show(String... toto) {
        System.out.println(Arrays.toString(toto));
    }
}