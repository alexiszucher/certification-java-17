package study.Generics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GenericTest {
    @Test
    void dot_renvoyer_le_generique_de_la_methode_si_un_dimant_T_devant() {
        Crate<Integer> crate = new Crate<>(4);
        Assertions.assertEquals("Toto", crate.showGeneric("Toto"));
    }

    @Test
    void dot_renvoyer_le_generique_de_l_instance_de_l_objet_si_pas_de_diamant_T_devant() {
        Crate<Integer> crate = new Crate<>(4);
        Assertions.assertEquals(4, crate.content());
    }
}
