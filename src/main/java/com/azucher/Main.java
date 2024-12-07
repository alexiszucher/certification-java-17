package com.azucher;

import com.azucher.aquarium.Water;

public class Main {
    static int toto() {
        return toto() + 1;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        Water water = new Water();
        int o = toto();
    }
}