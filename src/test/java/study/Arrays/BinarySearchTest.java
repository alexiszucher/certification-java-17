package study.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinarySearchTest {
    @Test
    void doit_trouver_la_donnee_en_index_1() {
        String[] tab1 = {"Alexis", "Laura", "Victoire"};
        Assertions.assertEquals(2, Arrays.binarySearch(tab1, "Victoire"));
    }

    @Test
    void ne_doit_pas_trouver_la_donnee_si_tableau_pas_trie() {
        String[] tab1 = {"Alexis", "Victoire", "Laura"};
        Assertions.assertTrue(Arrays.binarySearch(tab1, "Laura") < 0);
    }

    @Test
    void quand_ce_n_est_pas_trouve_je_verifie_que_l_index_renvoye_est_l_index_ou_cela_aurait_du_etre_moins_1() {
        String[] tab1 = {"Alexis", "Laura", "Victoire"};
        Assertions.assertEquals(-2, Arrays.binarySearch(tab1, "Felix"));
    }
}
