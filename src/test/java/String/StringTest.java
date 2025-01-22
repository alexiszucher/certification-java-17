package String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void peut_substring_plus_loin_que_la_chaine_complete() {
        String toto = "ABCDEFG";
        Assertions.assertEquals("", toto.substring(1, toto.length()));
    }
}
