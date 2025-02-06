package study.exception;

import java.io.IOException;

public class CountList {
    public static int count() throws IOException {
        throw new IOException();
    }

    public static int countSafe() {
        try {
            return count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
