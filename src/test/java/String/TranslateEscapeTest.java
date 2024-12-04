package String;

import org.junit.jupiter.api.Test;

public class TranslateEscapeTest {
    @Test
    void test() {
        var base = "ewe\nsheep\\t";
        base = base.translateEscapes();
        System.out.println(base);
    }
}
