package study.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    void peut_mapper_sur_un_iterate_et_renvoyer_un_ReferencePipeline() {
        Stream<String> iterate = Stream.iterate("", s -> s + "1");
        // TODO ceci renvoie un java.util.stream.ReferencePipeline$3@4517d9a3 (ou référence similaire)
        System.out.println(iterate.limit(2).map(s -> s + "2"));
    }

    @Test
    void provoque_une_boucle_infini_si_generate_et_allMatch_est_utilise() {
        Predicate<String> contientG = s -> s.startsWith("G");
        Stream<String> stream = Stream.generate(() -> "Growl !");
        Stream<String> stream2 = Stream.generate(() -> "Growl !");

        boolean result = stream.anyMatch(contientG);

        Assertions.assertTrue(result);

        result = stream2.allMatch(contientG);

        Assertions.assertTrue(result);
    }

    @Test
    void une_IllegalStateException_est_levee_si_variable_stream_utilisee_deux_fois() {
        Predicate<String> plusGrandQue3Caracteres = s -> s.length() > 3;
        Stream<String> stream = Stream.iterate("-", s -> !s.isEmpty(), s -> s + s);
        boolean result = stream.noneMatch(plusGrandQue3Caracteres);
        Assertions.assertFalse(result);
        Assertions.assertThrows(IllegalStateException.class, () -> {
            stream.anyMatch(plusGrandQue3Caracteres);
        });
    }

    @Test
    void peut_utiliser_la_methode_sorted_pour_trier() {
        // TODO il n'y a pas de compare ou de compareTo avec les Stream !
        List<String> actual = List.of("Toto", "Tata").stream().sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
        List<String> expected = List.of("Tata", "Toto");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void peut_utiliser_reduce() {
        List<Integer> actual = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        int result = actual.stream().reduce(0, (a, b) -> a + b);
        Assertions.assertEquals(45, result);
    }

    @Test
    void peut_tranformer_liste_en_map_avec_traitement() {
        List<String> animals = List.of("cat", "dog", "tiger", "lion", "monkey");
        Map<Integer, String> animalMap = animals.stream().collect(Collectors.toMap(String::length, k -> k, (s1, s2) -> s1 + ", " + s2));
        animalMap.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}
