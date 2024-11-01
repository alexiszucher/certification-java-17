import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class MathFunctions {
    public static void main(String[] args) {
        final int[] compteur = {0};
        var intList = Stream.generate(() -> compteur[0]++).limit(5).toList();
        intList.stream().parallel().forEachOrdered(System.out::println);
    }
}