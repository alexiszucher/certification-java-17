package practice.chapter1;

import org.junit.jupiter.api.Test;

public class MathTest {
    @Test
    void renvoi_des_methodes_math() {
        // TODO ceil renvoie double
        double result1 = Math.ceil(14);

        // TODO max renvoie int
        int result2 = Math.max(14, 15);

        // TODO pow renvoie double
        double result3 = Math.pow(14, 2);
    }
}
