package Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CompareTest {
    @Test
    void doit_retourner_une_valeur_positive_car_le_premier_tableau_est_lexicologiquement_plus_grand() {
        String[] tab1 = {"Alexis", "Victoire", "Laura"};
        String[] tab2 = {"Alexis", "Victoird", "Laura"};
        Assertions.assertTrue(Arrays.compare(tab1, tab2) > 0);
    }

    @Test
    void doit_retourner_une_valeur_negative_car_le_premier_tableau_est_lexicologiquement_plus_petit() {
        String[] tab1 = {"Alexis", "Victoir", "Laura"};
        String[] tab2 = {"Alexis", "Victoire", "Laura"};
        Assertions.assertTrue(Arrays.compare(tab1, tab2) < 0);
    }

    @Test
    void doit_retourner_une_valeur_negative_car_le_premier_tableau_est_plus_petit_que_le_deuxieme_parce_que_le_deuxieme_contient_null_en_plus() {
        String[] tab1 = {"Alexis"};
        String[] tab2 = {"Alexis", null};
        Assertions.assertTrue(Arrays.compare(tab1, tab2) < 0);
    }
}
