package classe;

import classe.override.Fish;
import classe.override.Shark;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ClasseTest {
    @Test
    void la_methode_override_doit_renvoyer_le_requin_qui_nage_au_lieu_du_poisson() {
        Fish fish = new Shark();
        Assertions.assertEquals("Shark swim", fish.swim());
    }

    @Test
    void la_methode_static_ne_peut_pas_etre_override_et_peut_quand_meme_etre_appele_par_un_enfant() {
        Assertions.assertEquals("Fish", Shark.name());
    }

    @Test
    void la_variable_speed_du_requin_doit_s_afficher_au_lieu_du_poisson() {
        Fish fish = new Shark();
        Assertions.assertEquals(2, fish.getSpeed());
    }

    @Test
    void attention_au_classe_muable_par_les_getter() {
        Animal animal = new Animal();
        Assertions.assertEquals(List.of("Dog"), animal.animals());

        animal.animals().add("Cat");

        // L'objet est muable ! Pensez à renvoyer une copie de la liste et non la liste dans le getter
        Assertions.assertNotEquals(List.of("Dog"), animal.animals());
        Assertions.assertEquals(List.of("Dog", "Cat"), animal.animals());
    }

    @Test
    void peut_acceder_aux_variables_privees_d_une_sous_classe() {
        Assertions.assertEquals(2, new OuterClass().new InnerClass().getNum());
    }

}

class OuterClass {
    class InnerClass {
        private int num = 2;

        public int getNum() {
            return num;
        }
    }
}
