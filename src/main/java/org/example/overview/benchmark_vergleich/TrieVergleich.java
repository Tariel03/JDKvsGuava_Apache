package org.example.overview.benchmark_vergleich;

import org.apache.commons.collections4.trie.PatriciaTrie;
import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime) // Measure average time per operation
@OutputTimeUnit(TimeUnit.NANOSECONDS) // Results in nanoseconds
@State(Scope.Thread)
public class TrieVergleich {
    private static StandardTrie standardTrie;
    private static PatriciaTrie<Boolean> patriciaTrie;

    @Setup(Level.Iteration) // Setup before each test iteration
    public static void setup() {
        standardTrie = new StandardTrie();
        patriciaTrie = new PatriciaTrie<>();
        List<String> words = List.of("apple", "banana", "grape", "orange", "pineapple", "watermelon");

        for (String word : words) {
            standardTrie.insert(word);
            patriciaTrie.put(word, true);
        }
    }

    @Benchmark
    public static void testStandardTrieInsert() {
        standardTrie.insert("new_word" + new Random().nextInt(10000));
    }

    @Benchmark
    public static void testPatriciaTrieInsert() {
        patriciaTrie.put("new_word" + new Random().nextInt(10000), true);
    }

    @Benchmark
    public static boolean testStandardTrieSearch() {
        return standardTrie.search("banana");
    }

    @Benchmark
    public static boolean testPatriciaTrieSearch() {
        return patriciaTrie.containsKey("banana");
    }
}

class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
}

class StandardTrie {
    private final TrieNode root;

    public StandardTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.computeIfAbsent(ch, c -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current = current.children.get(ch);
            if (current == null) {
                return false;
            }
        }
        return current.isEndOfWord;
    }
}