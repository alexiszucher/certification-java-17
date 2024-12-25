package Collection;

import io.cucumber.java.eo.Se;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CollectionTest {
    @Test
    void peut_utiliser_l_operateur_diamant() {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> listWithDiamond = new ArrayList<>();

        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        Map<Integer, List<String>> mapWithDiamond = new HashMap<>();
    }

    @Test
    void doit_declarer_le_type_a_gauche() {
        List<Integer> list = new ArrayList<>();
        // TODO NE COMPILE PAS
        // List<> list2 = new ArrayList<Integer>();
    }

    @Test
    void la_methode_add_retourne_un_booleen() {
        List<Integer> list = new ArrayList<>();
        boolean result = list.add(4);
        Assertions.assertTrue(result);
    }

    @Test
    void la_methode_remove_retourne_un_booleen() {
        List<String> list = new ArrayList<>();
        list.add("Toto");
        list.add("Tata");
        list.add("Titi");
        boolean result = list.remove("Titi");
        Assertions.assertTrue(result);
        Assertions.assertFalse(list.remove("LALA"));
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void peut_utiliser_isEmpty_et_size() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);

        Assertions.assertFalse(queue.isEmpty());
        Assertions.assertEquals(2, queue.size());
    }

    @Test
    void peut_utiliser_clear() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);

        Assertions.assertEquals(2, queue.size());
        queue.clear();
        Assertions.assertEquals(0, queue.size());
    }

    @Test
    void peut_utiliser_contains() {
        Queue<String> queue = new LinkedList<>();
        queue.add("Toto");
        queue.add("Tata");

        Assertions.assertTrue(queue.contains("Toto"));
        Assertions.assertFalse(queue.contains("Titi"));
    }

    @Test
    void peut_utiliser_removeIf() {
        Queue<String> queue = new LinkedList<>();
        queue.add("Toto");
        queue.add("Tata");
        queue.add("Animal");

        boolean result = queue.removeIf(s -> s.startsWith("T"));
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, queue.size());
        Assertions.assertTrue(queue.contains("Animal"));
    }

    @Test
    void doit_utiliser_un_consumer_dans_le_forEach() {
        List<String> list = new ArrayList<>();
        list.add("Toto");
        list.add("Tata");
        list.add("Animal");

        Consumer<String> printAll = System.out::println;
        list.forEach(printAll);
    }

    @Test
    void la_methode_equals_controle_l_ordre_pour_List_mais_pas_pour_Set() {
        List<Integer> list = List.of(1, 2);
        List<Integer> list2 = List.of(2, 1);
        Assertions.assertFalse(list.equals(list2));

        Set<Integer> set = Set.of(1, 2);
        Set<Integer> set2 = Set.of(2, 1);
        Assertions.assertTrue(set.equals(set2));
    }

    @Test
    void peut_ajouter_null_a_une_liste_et_provoquer_NullPointerException_avec_affectation() {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        Assertions.assertThrows(NullPointerException.class, () -> {int i = list.get(0);});
    }

    @Test
    void array_as_list_pointe_sur_la_meme_reference() {
        String[] array = new String[] {"a", "b", "c"};
        List<String> list = Arrays.asList(array);

        Assertions.assertFalse(list.contains("z"));
        array[0] = "z";
        Assertions.assertTrue(list.contains("z"));

        list.set(2, "j");
        Assertions.assertEquals(2, Arrays.binarySearch(array, "j"));
    }

    @Test
    void est_immuable_en_cas_de_copyOf() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        List<String> list2 = List.copyOf(list);
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {list2.add("j");});
    }

    @Test
    void peut_utiliser_replaceAll() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);

        list.replaceAll(x -> x * 2);

        Assertions.assertEquals(List.of(4, 8, 12), list);
    }

    @Test
    void peut_utiliser_TreeSet() {
        Set<String> set = new TreeSet<>();
        set.add("Zoo");
        set.add("Animal");
        set.add("Dodo");

        set.forEach(System.out::println);
    }

    @Test
    void peut_utiliser_peak_addFirst_et_remove_pour_une_queue() {
        Deque<String> queue = new LinkedList<>();
        queue.add("Toto");
        queue.add("Tata");

        Assertions.assertEquals("Toto", queue.peek());
        queue.remove();
        Assertions.assertEquals("Tata", queue.peek());

        queue.addFirst("Titi");
        Assertions.assertEquals("Titi", queue.getFirst());

        queue.removeLast();
        Assertions.assertEquals("Titi", queue.getLast());
    }

    @Test
    void peut_utiliser_merge_pour_une_map() {
        Map<String, String> nameAndTransport = new HashMap<>();
        nameAndTransport.put("Toto", "Bus");
        nameAndTransport.put("Tata", "Voiture");
        nameAndTransport.put("Titi", "Train");
        BiFunction<String, String, String> mapper = (a, b) -> a.length() > b.length() ? a : b;

        nameAndTransport.merge("Toto", "Autobus", mapper);
        Assertions.assertEquals("Autobus", nameAndTransport.get("Toto"));

        nameAndTransport.merge("Toto", "Train", mapper);
        Assertions.assertEquals("Autobus", nameAndTransport.get("Toto"));
    }

    @Test
    void peut_utiliser_compare_pour_trier_une_treeSet() {
        Set<Animal> set = new TreeSet<>();
        set.add(new Animal("Lion"));
        set.add(new Animal("Tigre"));
        set.add(new Animal("Singe"));
        set.add(new Animal("Chat"));

        List<String> expected = List.of("Chat", "Lion", "Singe", "Tigre");

        int i = 0;
        for (Animal animal : set) {
            Assertions.assertEquals(expected.get(i), animal.name());
            i++;
        }
    }

    @Test
    void peut_surcharger_le_comparator() {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Lion"));
        list.add(new Animal("Tigre"));
        list.add(new Animal("Singe"));
        list.add(new Animal("Chat"));

        Comparator<Animal> byDescendingName = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o2.name().compareTo(o1.name());
            }
        };

        list.sort(byDescendingName);

        List<String> expected = List.of("Tigre", "Singe",  "Lion", "Chat");

        int i = 0;
        for (Animal animal : list) {
            Assertions.assertEquals(expected.get(i), animal.name());
            i++;
        }
    }

    @Test
    void peut_recuperer_les_noms_commencant_par_une_lettre() {
        List<String> animals = List.of("Tigre", "Singe",  "Lion", "Chat");

        List<String> actual = animals.stream().filter(animal -> animal.startsWith("T")).toList();
        List<String> expected = List.of("Tigre");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void peut_transformer_une_liste_en_map_en_regroupant_par_le_nombre_de_lettres() {
        List<String> animals = List.of("Tigre", "Singe",  "Lion", "Chat");

        Map<Integer, List<String>> actual = animals.stream()
                .collect(Collectors.groupingBy(String::length));
        Map<Integer, List<String>> expected = Map.of(
                5, List.of("Tigre", "Singe"),
                4, List.of("Lion", "Chat")
        );

        Assertions.assertEquals(expected, actual);

        Map<Integer, Set<String>> actualSet = animals.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        Map<Integer, Set<String>> expectedSet = Map.of(
                5, Set.of("Tigre", "Singe"),
                4, Set.of("Lion", "Chat")
        );

        Assertions.assertEquals(expectedSet, actualSet);
    }

    @Test
    void peut_utiliser_le_partitionning_pour_traiter_rapidement_une_liste() {
        List<String> animals = List.of("Tigre", "Singe", "Lion", "Chat");

        Map<Boolean, List<String>> animauxPlusGrandQue4Caracteres = animals.stream().collect(Collectors.partitioningBy(s -> s.length() > 4));
        Map<Boolean, List<String>> expected = Map.of(
                true, List.of("Tigre", "Singe"),
                false, List.of("Lion", "Chat")
        );

        Assertions.assertEquals(expected, animauxPlusGrandQue4Caracteres);
    }
}
