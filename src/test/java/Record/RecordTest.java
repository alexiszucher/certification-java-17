package Record;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecordTest {
    @Test
    void si_pas_de_record_la_methode_equals_controle_la_reference() {
        Fox fox = new Fox("Un renard");
        Fox fox2 = new Fox("Un renard");

        Assertions.assertNotEquals(fox, fox2);
    }

    @Test
    void si_record_la_methode_equals_controle_les_champs() {
        FoxRecord fox = new FoxRecord("Un renard");
        FoxRecord fox2 = new FoxRecord("Un renard");

        Assertions.assertEquals(fox, fox2);
    }

    @Test
    void utilisation_des_constructeurs_compacts_et_a_la_fin_le_record_utilise_implicetement_son_constructeur_classique_pour_assigner_les_proprietes() {
        FoxRecord fox = new FoxRecord("Un renard");
        Assertions.assertEquals("UN RENARD", fox.name());
    }

    @Test
    void overload_du_constructeur() {
        FoxRecord fox = new FoxRecord("Un renard", "tout petit");
        Assertions.assertEquals("UN RENARD TOUT PETIT", fox.name());
    }

    @Test
    void ne_peut_pas_mettre_de_setter_car_les_champs_sont_final() {
        record ManchotPenguin(int height) {
            public void setHeight(int height) {
                // TODO DOES NOT COMPILE
                // this.height = height;
            }
        }
    }
}
