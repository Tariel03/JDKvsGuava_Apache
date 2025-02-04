package org.example.overview.comparison.bimap;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.Random;

public class BiMapBenchmark {
    private static final int SIZE = 100000; // Number of key-value pairs
    private static final int LOOKUP_KEY = 50000;
    private static final int LOOKUP_VALUE = 25000;

    public static void main(String[] args) {
        benchmarkGuavaBiMap();
        benchmarkApacheBidiMap();
    }

    private static void benchmarkGuavaBiMap() {
        BiMap<Integer, String> guavaBiMap = HashBiMap.create();
        Random random = new Random();

        long start, end;

        // Measure Insertion Time
        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            String value = "Value" + random.nextInt(SIZE);
            guavaBiMap.forcePut(i, value); // Using forcePut to allow duplicate values
        }
        end = System.nanoTime();
        System.out.println("Guava BiMap Insert Time: " + (end - start) + " ns");

        // Measure Forward Lookup Time
        start = System.nanoTime();
        guavaBiMap.get(LOOKUP_KEY);
        end = System.nanoTime();
        System.out.println("Guava BiMap Forward Lookup Time: " + (end - start) + " ns");

        // Measure Reverse Lookup Time
        start = System.nanoTime();
        guavaBiMap.inverse().get("Value" + LOOKUP_VALUE);
        end = System.nanoTime();
        System.out.println("Guava BiMap Reverse Lookup Time: " + (end - start) + " ns");

        // Measure Memory Usage
        System.gc();
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Guava BiMap Memory Usage: " + memoryUsed + " bytes\n");
    }


    private static void benchmarkApacheBidiMap() {
        DualHashBidiMap<Integer, String> apacheBidiMap = new DualHashBidiMap<>();
        Random random = new Random();

        long start, end;

        // Measure Insertion Time
        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            apacheBidiMap.put(i, "Value" + random.nextInt(1000));
        }
        end = System.nanoTime();
        System.out.println("Apache BidiMap Insert Time: " + (end - start) + " ns");

        // Measure Forward Lookup Time
        start = System.nanoTime();
        apacheBidiMap.get(LOOKUP_KEY);
        end = System.nanoTime();
        System.out.println("Apache BidiMap Forward Lookup Time: " + (end - start) + " ns");

        // Measure Reverse Lookup Time
        start = System.nanoTime();
        apacheBidiMap.getKey("Value" + LOOKUP_VALUE);
        end = System.nanoTime();
        System.out.println("Apache BidiMap Reverse Lookup Time: " + (end - start) + " ns");

        // Measure Memory Usage
        System.gc();
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Apache BidiMap Memory Usage: " + memoryUsed + " bytes\n");
    }
}
