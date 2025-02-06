package practice.chapter1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperatorTest {
    @Test
    void les_operateurs_non_courants_possibles() {
        // TODO le ^ permet de dire que les deux valeurs sont différentes, si c'est le cas renvoie true
        Assertions.assertTrue(false ^ true);
        Assertions.assertTrue(true ^ false);
        Assertions.assertFalse(false ^ false);

        // TODO le & permet de dire que deux opérandes renvoi true, c'est différent du && car toutes les parties sont exécutées.
        Assertions.assertTrue(true & true);
        Assertions.assertFalse(false & true);
        Assertions.assertFalse(false & true);
    }

    @Test
    void l_operateur_tild_fait_une_negation_et_soustrait_1() {
        int i = 9;
        int j = -9;
        Assertions.assertEquals(-10, ~i);
        Assertions.assertEquals(8, ~j);
    }
}
