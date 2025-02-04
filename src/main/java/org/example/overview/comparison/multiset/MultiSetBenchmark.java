package org.example.overview.comparison.multiset;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.Bag;

import java.util.Random;

public class MultiSetBenchmark {
    private static final int SIZE = 100000; // Number of elements to insert
    private static final int LOOKUP_ELEMENT = 5000; // Element to check count

    public static void main(String[] args) {
        benchmarkGuavaMultiset();
        benchmarkApacheBag();
    }

    private static void benchmarkGuavaMultiset() {
        Multiset<Integer> guavaMultiset = HashMultiset.create();
        Random random = new Random();

        long start, end;

        // Measure Insertion Time
        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            guavaMultiset.add(random.nextInt(10000)); // Allowing duplicates
        }
        end = System.nanoTime();
        System.out.println("Guava Multiset Insert Time: " + (end - start) + " ns");

        // Measure Lookup Time
        start = System.nanoTime();
        guavaMultiset.count(LOOKUP_ELEMENT);
        end = System.nanoTime();
        System.out.println("Guava Multiset Count Lookup Time: " + (end - start) + " ns");

        // Measure Memory Usage
        System.gc();
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Guava Multiset Memory Usage: " + memoryUsed + " bytes\n");
    }

    private static void benchmarkApacheBag() {
        Bag<Integer> apacheBag = new HashBag<>();
        Random random = new Random();

        long start, end;

        // Measure Insertion Time
        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            apacheBag.add(random.nextInt(10000)); // Allowing duplicates
        }
        end = System.nanoTime();
        System.out.println("Apache Bag Insert Time: " + (end - start) + " ns");

        // Measure Lookup Time
        start = System.nanoTime();
        apacheBag.getCount(LOOKUP_ELEMENT);
        end = System.nanoTime();
        System.out.println("Apache Bag Count Lookup Time: " + (end - start) + " ns");

        // Measure Memory Usage
        System.gc();
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Apache Bag Memory Usage: " + memoryUsed + " bytes\n");
    }
}
