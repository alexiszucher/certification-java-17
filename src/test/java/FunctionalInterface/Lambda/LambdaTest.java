package FunctionalInterface.Lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.*;

public class LambdaTest {
    @Test
    void unary_operator_doit_faire_un_traitement_et_produire_un_resultat_de_meme_type() {
        UnaryOperator<Long> operator = x -> x * 2;
        Assertions.assertEquals(4, operator.apply(2L));
    }

    @Test
    void function_doit_avoir_en_premier_type_l_entree_et_en_deuxieme_type_la_sortie() {
        Function<Long, String> function = x -> "Il y a " + x + " cochons";
        Assertions.assertEquals("Il y a 5 cochons", function.apply(5L));
    }

    @Test
    void consumer_doit_avoir_un_argument_et_retourner_void() {
        Consumer<String> consumer = System.out::println;
    }

    @Test
    void biPredicate_doit_avoir_deux_arguments_et_retourner_boolean() {
        BiPredicate<String, String> consumer = String::equals;
        Assertions.assertFalse(consumer.test("a", "b"));
        Assertions.assertTrue(consumer.test("a", "a"));
    }

    @Test
    void peut_utiliser_la_methoe_and_et_negate_sur_predicate() {
        Predicate<String> saitSprinter = x -> x.contains("sprint");
        Predicate<String> saitSauter = x -> x.contains("saut");

        Predicate<String> saitSprinterEtSauter = saitSprinter.and(saitSauter.negate());
    }

    @Test
    void peut_utiliser_andThen_sur_un_consumer() {
        Consumer<String> titre = System.out::println;
        Consumer<String> contenu = System.out::println;

        Consumer<String> paragraphe = titre.andThen(contenu);
    }

    @Test
    void peut_utiliser_compose_sur_function() {
        Function<Long, Long> add3 = x -> x + 3;
        Function<Long, Long> multiplyBy2 = x -> x * 2;

        Function<Long, Long> combinedFunctions = multiplyBy2.compose(add3);

        Assertions.assertEquals(10, combinedFunctions.apply(2L));
    }

    @Test
    void doit_pouvoir_utiliser_booleanSupplier() {
        BooleanSupplier estPlusGrandQue2 = () -> false;
        Assertions.assertFalse(estPlusGrandQue2.getAsBoolean());
    }

    @Test
    void doit_pouvoir_utiliser_DoubleToIntFunction() {
        var d = 1.0;
        DoubleToIntFunction f1 = x -> 1;
        f1.applyAsInt(d);
    }

    @Test
    void doit_utiliser_la_function_dans_le_compose_avant() {
        Function<Integer, Integer> s = a -> a + 4;
        Function<Integer, Integer> t = a -> a * 3;
        Function<Integer, Integer> c = s.compose(t);
        Assertions.assertEquals(7, c.apply(1));
    }

    @Test
    void test() {
        Predicate<Integer> t = (a) -> false;
    }
}
