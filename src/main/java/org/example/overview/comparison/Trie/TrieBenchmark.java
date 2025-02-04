package org.example.overview.comparison.Trie;

import org.apache.commons.collections4.trie.PatriciaTrie;
import org.example.overview.comparison.SimpleTrie;

import java.util.Map;
import java.util.Random;

public class TrieBenchmark {
    private static final int SIZE = 10000;
    private static final String[] KEYS = new String[SIZE];

    public static void main(String[] args) {
        PatriciaTrie<String> patriciaTrie = new PatriciaTrie<>();
        SimpleTrie simpleTrie = new SimpleTrie();
        Random random = new Random();

        // Generate random keys
        for (int i = 0; i < SIZE; i++) {
            KEYS[i] = "key" + random.nextInt(SIZE);
        }

        long start, end;

        // Insert into PatriciaTrie
        start = System.nanoTime();
        for (String key : KEYS) {
            patriciaTrie.put(key, "value");
        }
        end = System.nanoTime();
        System.out.println("PatriciaTrie Insert Time: " + (end - start) + " ns");

        // Insert into SimpleTrie
        start = System.nanoTime();
        for (String key : KEYS) {
            simpleTrie.insert(key);
        }
        end = System.nanoTime();
        System.out.println("SimpleTrie Insert Time: " + (end - start) + " ns");

        // Lookup in PatriciaTrie
        start = System.nanoTime();
        patriciaTrie.get(KEYS[500]);
        end = System.nanoTime();
        System.out.println("PatriciaTrie Lookup Time: " + (end - start) + " ns");

        // Lookup in SimpleTrie
        start = System.nanoTime();
        simpleTrie.search(KEYS[500]);
        end = System.nanoTime();
        System.out.println("SimpleTrie Lookup Time: " + (end - start) + " ns");
    }
}
