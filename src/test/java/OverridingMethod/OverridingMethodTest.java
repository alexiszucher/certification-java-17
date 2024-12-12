package OverridingMethod;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OverridingMethodTest {
    @Test
    void doit_utiliser_la_methode_de_l_enfant() {
        Assertions.assertEquals(20, new EmperorPenguin().height());
    }

    @Test
    void doit_utiliser_la_methode_du_parent_si_c_est_static() {
        Assertions.assertEquals(273, new EmperorPenguin().weight());
    }

    @Test
    void doit_utiliser_la_propriete_du_parent() {
        EmperorPenguin emperorPenguin = new EmperorPenguin();
        Penguin penguin = emperorPenguin;
        Assertions.assertEquals("White", emperorPenguin.color);
        Assertions.assertEquals("Black", penguin.color);
    }

    class Penguin {
        public String color = "Black";

        static public int getWeight() {
            return 273;
        }

        public int getHeight() {
            return 10;
        }

        public int height() {
            return getHeight();
        }

        public int weight() {
            return getWeight();
        }
    }

    class EmperorPenguin extends Penguin {
        public String color = "White";

        static public int getWeight() {
            return 394;
        }

        public int getHeight() {
            return 20;
        }
    }
}
