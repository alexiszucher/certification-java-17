package com.azucher.aquarium;

public class Tank {
    private static final int NUM_SECONDS_PER_MINUTE;
    private static final int NUM_MINUTES_PER_HOUR;
    private static final int NUM_SECONDS_PER_HOUR;

    static {
        NUM_SECONDS_PER_MINUTE = 60;
        NUM_MINUTES_PER_HOUR = 60;
    }

    static {
        NUM_SECONDS_PER_HOUR
                = NUM_SECONDS_PER_MINUTE * NUM_MINUTES_PER_HOUR;
    }

    private int toto = 3;

    public int getToto() {
        return toto;
    }

    public void setToto(int toto) {
        this.toto = toto;
    }

    public void print(Water water) {
        Water water1 = new Water();
        System.out.println(water);
        int i = 0;
        i = NUM_MINUTES_PER_HOUR;
    }

    class Toto {

    }
}

