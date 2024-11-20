package com.azucher;

public class Main {
    private transient Integer age;

    public static void main(String[] args) {
        byte apples = 5;
        short oranges = 10;

        boolean sunny = true, raining = false, sunday = true;
        boolean goingToTheStore = sunny & raining ^ sunday;
        boolean goingToTheZoo = sunday && !raining;
        boolean stayingHome = !(goingToTheStore && goingToTheZoo);
        System.out.println(goingToTheStore + "-" + goingToTheZoo + "-" + stayingHome);

        int note = 4;
        int note2 = 4;
        short melody = (byte) (double) (note *= 2);
        double song = melody;
        float symphony = (float) ((song == 1_000f) ? song * 2L : song);
        int toto = 5;
        toto = ~toto;
        System.out.println(toto);
        if (estPlusHautQue4(toto)) {

        }


    }

    public static boolean estPlusHautQue4(int x) {
        return x > 4;
    }
}