package practice.chapter1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void il_n_y_a_pas_de_methode_reverse() {
        String toto = "OK";
        // TODO does not compile
        // toto.reverse();

        // TODO Compile avec StringBuilder !
        StringBuilder builder = new StringBuilder("toto");
        builder.reverse();
        System.out.println(builder);
    }

    @Test
    void string_builder_append_renvoie_un_objet_de_meme_reference() {
        StringBuilder builder = new StringBuilder("-");
        StringBuilder builder2 = builder.append("-");

        Assertions.assertTrue(builder == builder2);
    }

    @Test
    void utilisation_methode_strip() {
        String answer = " One Ans w     er          ";
        // TODO Supprime les espaces en début et fin
        Assertions.assertEquals("One Ans w     er", answer.strip());
        // TODO peut faire la même chose avec stripIndent et stripTrailing.
        String answer2 = answer.stripIndent();
        answer2 = answer2.stripTrailing();
        Assertions.assertEquals("One Ans w     er", answer2);
        Assertions.assertEquals("One Ans w     er", answer2);

        // TODO il existe aussi stripLeading permettant du supprimer les espaces qu'au début.
    }
}
