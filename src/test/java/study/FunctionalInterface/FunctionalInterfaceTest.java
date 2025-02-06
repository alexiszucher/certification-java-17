package study.FunctionalInterface;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FunctionalInterfaceTest {
    @Test
    void n_est_pas_obliger_d_implementer_to_string() {
        FunctionalInterfaceWithToStringMethod interfacee = () -> "Toto";
        Assertions.assertEquals("Toto", interfacee.lol());
    }

    @Test
    void peut_utiliser_deux_points_pour_implementer_une_interface_fonctionnel_avec_un_void() {
        Sprinter sprinter = System.out::println;
    }
}
