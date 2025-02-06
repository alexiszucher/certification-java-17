package study.AnonymousClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnonymousClassTest {
    @Test
    void doit_pouvoir_faire_une_classe_anonyme_d_une_classe_abstraite() {
        Addition addition = new Addition(5, 1);
        Assertions.assertEquals(6, addition.add());
    }

    @Test
    void doit_pouvoir_faire_une_classe_anonyme_d_une_interface() {
        Substraction substraction = new Substraction(5, 1);
        Assertions.assertEquals(4, substraction.substract());
    }
}
