package study.Cast;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InstanceOfTest {
    @Test
    void instance_of_doit_renvoyer_faux() {
        Wolf wolf = new Wolf() {
        };

        Assertions.assertFalse(wolf instanceof Dog);
    }


    interface Wolf {
    }

    interface Dog {
    }
}
