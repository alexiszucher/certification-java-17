package study.NestedClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NestedClassTest {
    @Test
    void peut_appeler_this_apres_le_nom_de_la_classe() {
        Animal animal = new Animal();
        Animal.Bird bird = animal.new Bird();
        Animal.Bird.Eagle eagle = bird.new Eagle();

        Assertions.assertTrue(eagle.showAllX().contains(20));
        Assertions.assertTrue(eagle.showAllX().contains(10));
        Assertions.assertTrue(eagle.showAllX().contains(5));
    }
}
