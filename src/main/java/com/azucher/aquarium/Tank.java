package com.azucher.aquarium;

class Tank {
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

    public void print(Water water) {
        Water water1 = new Water();
        System.out.println(water);
        int i = 0;
        i = NUM_MINUTES_PER_HOUR;
    }
}
