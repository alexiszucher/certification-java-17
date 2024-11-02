package com.azucher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PredicateImpl {
    public static void exec() {
        IntPredicate estPlusGrandQue10 = x -> x > 10;
        List<Integer> listeEntierEntre1Et100 = new ArrayList<>();
        IntStream.range(1, 101).parallel().filter(estPlusGrandQue10).forEach(listeEntierEntre1Et100::add);
        // listeEntierEntre1Et100.forEach(nombre -> System.out.println(estPlusGrandQue10.test(nombre)));
        int index = Arrays.binarySearch(listeEntierEntre1Et100.toArray(), 4);
        System.out.println(index);
        int[] array = {6,9,8};
        System.out.println("B" + Arrays.binarySearch(array,9));
        System.out.println("C" + Arrays.compare(array,
                new int[] {6, 9, 8}));
        System.out.println("M" + Arrays.mismatch(array,
                new int[] {6, 9, 8}));
        Comparator<Integer> x = (a, b) -> a - b;
    }
}