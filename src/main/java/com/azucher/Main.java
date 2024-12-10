package com.azucher;

import com.azucher.aquarium.IsSwimable;
import com.azucher.aquarium.Water;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        Water water = new Water();
        IsSwimable isSwimable = () -> System.out.println("swim");
        isSwimable.swim();
    }
}