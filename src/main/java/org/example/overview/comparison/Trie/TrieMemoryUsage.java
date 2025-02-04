package org.example.overview.comparison.Trie;

import org.apache.commons.collections4.trie.PatriciaTrie;
import org.example.overview.comparison.SimpleTrie;

public class TrieMemoryUsage {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        PatriciaTrie<String> patriciaTrie = new PatriciaTrie<>();
        SimpleTrie simpleTrie = new SimpleTrie();

        // Insert data
        for (int i = 0; i < 10000; i++) {
            String key = "key" + i;
            patriciaTrie.put(key, "value");
            simpleTrie.insert(key);
        }

        // Measure memory usage
        runtime.gc();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory Used (PatriciaTrie): " + memoryBefore + " bytes");

        runtime.gc();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory Used (SimpleTrie): " + memoryAfter + " bytes");
    }
}
