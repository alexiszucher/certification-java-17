package Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MismatchTest {
    @Test
    void shouldMismatchAtIndex1() {
        String[] tab1 = {"a", "b", "c"};
        String[] tab2 = {"a", "c", "c"};
        Assertions.assertEquals(1, Arrays.mismatch(tab1, tab2));

        String[] tab3 = {"a"};
        String[] tab4 = {"a", null};
        Assertions.assertEquals(1, Arrays.mismatch(tab3, tab4));
    }

    @Test
    void shouldMismatchAtIndex3() {
        String[] tab1 = {"a", "b", "c", "c", "c", "c", "c"};
        String[] tab2 = {"a", "b", "c", "d", "e"};
        Assertions.assertEquals(3, Arrays.mismatch(tab1, tab2));
    }

    @Test
    void si_pas_de_difference_alors_moins_1() {
        String[] tab1 = {"a", "b", "c"};
        String[] tab2 = {"a", "b", "c"};
        Assertions.assertEquals(-1, Arrays.mismatch(tab1, tab2));
    }
}
