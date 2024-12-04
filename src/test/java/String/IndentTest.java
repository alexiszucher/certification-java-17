package String;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndentTest {
    @Test
    void doit_indenter_deux_fois_en_debut_de_string_et_rajouter_un_saut_de_ligne_a_la_fin_et_est_considere_comme_trois_caracteres_dans_le_length() {
        String base = "Toto";
        assertEquals(4, base.length());

        base = base.indent(2);

        System.out.println(base);
        assertEquals(7, base.length());
    }
}
