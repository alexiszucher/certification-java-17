package com.azucher;

import java.util.Arrays;

public class Main {
    private transient Integer age;

    public static void main(String[] args) {
        var arr = """
                purr""";
        System.out.println(arr.length());
    }

    public static void show(String... toto) {
        System.out.println(Arrays.toString(toto));
    }
}