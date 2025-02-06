package study.Cast;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CastTest {
    @Test
    void doit_soulever_une_ClassCastException_lors_d_un_mauvais_cast_d_interface_mais_le_code_compile() {
        Wolf wolf = new Wolf() {
        };

        Assertions.assertThrows(ClassCastException.class, () -> {
            Dog dog = (Dog) wolf;
        });
    }

    @Test
    void le_cast_n_est_pas_possible_si_le_parent_est_initialise_et_qu_on_essaye_de_le_cast_a_l_enfant() {
        Animal animal = new Animal();
        Assertions.assertThrows(ClassCastException.class, () -> {
            Fox fox = (Fox) animal;
        });
    }


    interface Wolf {
    }

    interface Dog {
    }
}
