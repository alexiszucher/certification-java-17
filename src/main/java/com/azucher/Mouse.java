package com.azucher;

public class Mouse {
    final static int MAX_LENGTH = 5;
    int length;
    double i = 2_234.0_0;
    boolean d;
    long var;

    public void Mouse() {
        var = 4;
    }

    public void grow(int inches, Mouse mouse) {
        if (length < MAX_LENGTH) {
            int newSize = length + inches;
            length = newSize;
        }
        System.out.println(var);
    }
}
