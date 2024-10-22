package org.example.overview.apache_commons;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualLinkedHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;

public class BidiMapOverview {
    public static void main(String[] args) {
        hashBiDiMapOverview();
        sortedBidiMap();
        linkedBidiMap();

    }
    public static void hashBiDiMapOverview(){
        BidiMap<String, String> bidiMap = new DualHashBidiMap<>();

        bidiMap.put("one", "1");
        bidiMap.put("five", "5");
        bidiMap.put("six", "6");
        bidiMap.put("four", "4");
        bidiMap.put("seven", "7");
        bidiMap.put("three", "3");
        System.out.println("Value for 'one': " + bidiMap.get("one"));  // Output: 1

        //Man bekommt den Schlüssel durch den Wert.
        System.out.println("Key for value 2: " + bidiMap.getKey("2"));  // Output: two

        System.out.println(bidiMap);

        //Man löscht ein Wert
        bidiMap.removeValue("3");
        System.out.println("Map after removing value 3: " + bidiMap);  // Output: {one=1, two=2}

        System.out.println(bidiMap);
        //Hier reversiert man bidiMap a(Schlüssel):b(Wert) -> b(Schlüssel) : a(Wert);
        System.out.println(bidiMap.inverseBidiMap());
        System.out.println();
    }
    public static void sortedBidiMap(){
        //Hier erzeugt man sortierte BidiMap
        BidiMap<String, String> sortedBidiMap = new DualTreeBidiMap<>();

        sortedBidiMap.put("one", "1");
        sortedBidiMap.put("five", "5");
        sortedBidiMap.put("six", "6");
        sortedBidiMap.put("four", "4");
        sortedBidiMap.put("seven", "7");
        sortedBidiMap.put("three", "3");

        System.out.println("Sorted BidiMap by key: " + sortedBidiMap);  // Output: {apple=5, banana=3, cherry=7}

        System.out.println("Key for value 1: " + sortedBidiMap.getKey("1"));  // Output: apple
        System.out.println("Sorted BidiMap by value: " + sortedBidiMap.inverseBidiMap());
        System.out.println();
    }

    public static void linkedBidiMap(){
        //Hier erzeugt man sortierte LinkedBidiMap, das bedeutet, die Einfüge reihenfolge der Elemente wird gespeichert
        BidiMap<String, String> linkedBidiMap = new DualLinkedHashBidiMap<>();

        linkedBidiMap.put("one", "1");
        linkedBidiMap.put("five", "5");
        linkedBidiMap.put("six", "6");
        linkedBidiMap.put("four", "4");
        linkedBidiMap.put("seven", "7");
        linkedBidiMap.put("three", "3");

        System.out.println("Sorted BidiMap by key: " +  linkedBidiMap);  // Output: {apple=5, banana=3, cherry=7}

        System.out.println("Key for value 1: " +   linkedBidiMap.getKey("1"));  // Output: apple
        System.out.println("Sorted BidiMap by value: " +   linkedBidiMap.inverseBidiMap());
        System.out.println();
    }
}
