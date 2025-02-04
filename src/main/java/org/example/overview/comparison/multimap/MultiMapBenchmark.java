package org.example.overview.comparison.multimap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.collections4.MultiValuedMap;

import java.util.Random;

public class MultiMapBenchmark {

    private static final int SIZE = 100000; // Number of key-value pairs
    private static final int LOOKUP_KEY = 50000; // Key for search
    private static final int VALUES_PER_KEY = 5; // Number of values per key

    public static void main(String[] args) {
        benchmarkGuavaMultimap();
        benchmarkApacheMultiValuedMap();
    }

    private static void benchmarkGuavaMultimap() {
        Multimap<Integer, String> guavaMultimap = ArrayListMultimap.create();
        Random random = new Random();

        long start, end;

        // Measure Insertion Time
        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < VALUES_PER_KEY; j++) {
                guavaMultimap.put(i, "Value" + random.nextInt(1000));
            }
        }
        end = System.nanoTime();
        System.out.println("Guava Multimap Insert Time: " + (end - start) + " ns");

        // Measure Lookup Time
        start = System.nanoTime();
        guavaMultimap.get(LOOKUP_KEY);
        end = System.nanoTime();
        System.out.println("Guava Multimap Lookup Time: " + (end - start) + " ns");

        // Measure Memory Usage
        System.gc();
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Guava Multimap Memory Usage: " + memoryUsed + " bytes\n");
    }

    private static void benchmarkApacheMultiValuedMap() {
        MultiValuedMap<Integer, String> apacheMultiValuedMap = new ArrayListValuedHashMap<>();
        Random random = new Random();

        long start, end;

        // Measure Insertion Time
        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < VALUES_PER_KEY; j++) {
                apacheMultiValuedMap.put(i, "Value" + random.nextInt(1000));
            }
        }
        end = System.nanoTime();
        System.out.println("Apache MultiValuedMap Insert Time: " + (end - start) + " ns");

        // Measure Lookup Time
        start = System.nanoTime();
        apacheMultiValuedMap.get(LOOKUP_KEY);
        end = System.nanoTime();
        System.out.println("Apache MultiValuedMap Lookup Time: " + (end - start) + " ns");

        // Measure Memory Usage
        System.gc();
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Apache MultiValuedMap Memory Usage: " + memoryUsed + " bytes\n");
    }
}
