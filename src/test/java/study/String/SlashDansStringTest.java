package study.String;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SlashDansStringTest {
    @Test
    void le_slash_n_saute_une_ligne_et_est_considere_comme_un_caractere_en_plus_dans_le_length() {
        String base = "ewe\nsheep";
        System.out.println(base);
        Assertions.assertEquals(9, base.length());
    }

    @Test
    void le_slash_t_doit_ajouter_un_tab_horizontal_et_est_considere_comme_un_caractere_en_plus_dans_le_length() {
        String base = "ewe\tsheep\t";
        System.out.println(base);
        Assertions.assertEquals(10, base.length());
    }

    @Test
    void le_double_slash_met_un_slash_dans_la_string() {
        String base = "sheep\\t";
        System.out.println(base);
        Assertions.assertEquals(7, base.length());
    }
}
