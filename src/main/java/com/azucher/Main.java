package com.azucher;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private transient Integer age;

    public static void main(String[] args) {
        Locale fr = new Locale("fr");
        Locale.setDefault(new Locale("en", "US"));
        var b = ResourceBundle.getBundle("Penguin", fr);
        System.out.println(b.getString("name"));
        Set<? extends RuntimeException> mySet = new TreeSet<RuntimeException>();
    }
}