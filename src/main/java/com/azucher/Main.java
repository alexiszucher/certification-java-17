package com.azucher;

import java.util.Arrays;

public class Main {
    private transient Integer age;

    public static void main(String[] args) {
        String[] s1 = {"Camel", "Peacock", "Llama"};
        String[] s2 = {"Camel", "Llama", "Peacock"};
        String[] s3 = {"Camel"};
        String[] s4 = {"Camel", null};
        System.out.println(Arrays.compare(s1, s2));
    }

    public static void show(String... toto) {
        System.out.println(Arrays.toString(toto));
    }
}