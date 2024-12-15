package org.example.overview.comparison;

import com.google.common.collect.HashMultiset;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.multiset.HashMultiSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Vergleich verschiedener MultiSet-Implementierungen:
 * - JDK: Nachahmung von MultiSet mit Map<K, Integer> zur Zählung von Vorkommen
 * - Guava: HashMultiset (erlaubt Duplikate und zählt Vorkommen)
 * - Apache Commons: HashMultiSet (ähnlich zu Guava's MultiSet)
 */
public class MultiSetComparisons {
    public static void main(String[] args) {
        // JDK MultiSet-Nachahmung mit Map
        Map<String, Integer> jdkMultiSet = new HashMap<>();
        addToCustomMultiSet(jdkMultiSet, "apple");
        addToCustomMultiSet(jdkMultiSet, "banana");
        addToCustomMultiSet(jdkMultiSet, "apple"); // "apple" wird zweimal hinzugefügt
        System.out.println("JDK MultiSet-Nachahmung: " + jdkMultiSet);

        // Guava MultiSets
        // HashMultiset: MultiSet ohne Sortierung
        HashMultiset<String> guavaHashMultiSet = HashMultiset.create();
        guavaHashMultiSet.add("apple");
        guavaHashMultiSet.add("banana");
        guavaHashMultiSet.add("apple", 2); // "apple" erscheint dreimal insgesamt
        System.out.println("Guava HashMultiset: " + guavaHashMultiSet);

        // Apache Commons MultiSets
        // HashMultiSet: MultiSet ohne Sortierung
        MultiSet<String> apacheHashMultiSet = new HashMultiSet<>();
        apacheHashMultiSet.add("apple");
        apacheHashMultiSet.add("banana");
        apacheHashMultiSet.add("apple", 2); // "apple" erscheint dreimal insgesamt
        System.out.println("Apache Commons HashMultiSet: " + apacheHashMultiSet);

        /*
        Test der MultiSet-spezifischen Methoden:
        - count: Anzahl der Vorkommen eines Elements
        - remove: Entfernen eines bestimmten Vorkommens
         */

        // Guava: Vorkommen zählen und reduzieren
        System.out.println("Anzahl der 'apple' in Guava HashMultiset: " + guavaHashMultiSet.count("apple"));
        guavaHashMultiSet.remove("apple", 2); // Entfernt 2 Vorkommen von "apple"
        System.out.println("Guava HashMultiset nach Entfernen: " + guavaHashMultiSet);

        // Apache Commons: Vorkommen zählen und reduzieren
        System.out.println("Anzahl der 'apple' in Apache HashMultiSet: " + apacheHashMultiSet.getCount("apple"));
        apacheHashMultiSet.remove("apple", 2);
        System.out.println("Apache Commons HashMultiSet nach Entfernen: " + apacheHashMultiSet);

        // JDK: Vorkommen zählen und reduzieren
        System.out.println("Anzahl der 'apple' in JDK MultiSet-Nachahmung: " + jdkMultiSet.get("apple"));
        removeFromCustomMultiSet(jdkMultiSet, "apple", 2); // Entfernt 2 Vorkommen von "apple"
        System.out.println("JDK MultiSet-Nachahmung nach Entfernen: " + jdkMultiSet);
    }

    // Methode zum Hinzufügen in JDK MultiSet-Nachahmung
    public static void addToCustomMultiSet(Map<String, Integer> multiSet, String element) {
        multiSet.put(element, multiSet.getOrDefault(element, 0) + 1);
    }

    // Methode zum Entfernen von Vorkommen in JDK MultiSet-Nachahmung
    public static void removeFromCustomMultiSet(Map<String, Integer> multiSet, String element, int count) {
        if (multiSet.containsKey(element)) {
            int currentCount = multiSet.get(element);
            if (currentCount <= count) {
                multiSet.remove(element);
            } else {
                multiSet.put(element, currentCount - count);
            }
        }
    }
}
