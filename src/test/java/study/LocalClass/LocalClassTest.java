package study.LocalClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocalClassTest {
    @Test
    void doit_pouvoir_faire_une_classe_dans_une_fonction() {
        Addition addition = new Addition(1, 5);
        Assertions.assertEquals(6, addition.compute());
    }
}
