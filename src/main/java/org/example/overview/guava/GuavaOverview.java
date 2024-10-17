package org.example.overview.guava;

import com.google.common.collect.*;
import com.google.errorprone.annotations.Immutable;

import java.util.*;

public class GuavaOverview {
    public static void main(String[] args) {
        immutableView();
        multiMapView();
        multiSetView();
        tableOverview();
        biMapView();


    }

    public static void immutableView(){

        /*
         Immutable Speicherplätzen, bedeutet dass, man nichts verändern, hinzufügen oder löschen kann.
         */
        //Immutable List!
        ImmutableList<String> immutableList = ImmutableList.of("apple", "banana", "tomato");
        System.out.println(immutableList);

        //Immutable Set
        Set<Integer> set = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        set.add(34);
        System.out.println(set);
        set.remove(34);
        System.out.println(set);
        ImmutableSet<Integer> integerImmutableSet = ImmutableSet.of(1, 2, 3, 4, 5, 6);
        System.out.println(integerImmutableSet);

        /*
        Es gibt viele verschiedene Immutable Classes und Schnittstellen, wie ImmutableSortedSet oder
        ImmutableTable, um unverändernbar Elementen zu erzeugen. Man kann benötigen ,wenn es Daten gibt
        die nicht verändern
         */

    }

    public static void multiMapView(){
         /*
        Man benutzt MultiMap interface um die Funktionalität von JDK-Map zu vergrößern.

         */

        //ArrayListMultiMap speichert die Werte von einem Schlüssel in ArrayList
        Multimap<String, String> multimap = ArrayListMultimap.create();

        multimap.put("fruit", "apple");
        multimap.put("fruit", "banana");
        multimap.put("fruit", "cherry");
        multimap.put("vegetable", "carrot");

        System.out.println("Fruits: " + multimap.get("fruit"));
        System.out.println("All entries: " + multimap.entries());
        System.out.println();


        //beim HashMultiMap speichert man alle Elemente (Schlüssel: [] → Werte in HashSet)!
        multimap = HashMultimap.create();

        multimap.put("dog", "bulldog");
        multimap.put("dog", "chihuahua");
        multimap.put("dog", "corgi");
        multimap.put("cat", "bald cat");

        System.out.println("Dogs : " + multimap.get("dog"));
        System.out.println("All entries: " + multimap.entries());
        System.out.println();

        //beim LinkedHashMultiMap speichert man alle Elemente (Schlüssel: [] → Werte in LinkedHashSet)!
        multimap = LinkedHashMultimap.create();

        multimap.put("dog", "bulldog");
        multimap.put("dog", "chihuahua");
        multimap.put("dog", "corgi");
        multimap.put("cat", "bald cat");
        multimap.put("cat", "lion");
        System.out.println("Dogs : " + multimap.get("dog"));
        System.out.println("All entries: " + multimap.entries());
        System.out.println();

        //sorted Multimap!
        multimap = TreeMultimap.create();
        multimap.put("dog", "bulldog");
        multimap.put("dog", "chihuahua");
        multimap.put("dog", "corgi");
        multimap.put("cat", "bald cat");
        multimap.put("cat", "lion");
        System.out.println("Dogs : " + multimap.get("dog"));
        System.out.println("All entries: " + multimap.entries());
        System.out.println();

    }


    public static void multiSetView(){
        /*
       Dann beschäftigt man sich mit Multiset, es bedeutet in einem Multiset es kann mehr als ein dasselbe Element, aber Multiset rechnet der Nummer von Elementen
        */

        //beim Multiset wurden die Daten, in HashSet speichert!
        Multiset<Integer> multiset = HashMultiset.create();
        multiset.addAll(List.of(1, 2, 3, 4, 5, 6, 6, 2, 1, 1));
        System.out.println("There are " + multiset.count(1) + " times, 1 was found in the multiset!");
        //Auch gibt es LinkedHashMultiSet, TreeMultiSet!
    }

    public static void tableOverview(){
        /*
        Hier wird die Schnittstelle Table hinzufügt
        Table benutzt um 2d objekten zu speichern in Map (R, C, V);
         */
        Table<String, String, Integer> hashTable = HashBasedTable.create();

        // Add entries (Row, Column, Value)
        hashTable.put("Apple", "Price", 150);
        hashTable.put("Apple", "Stock", 50);
        hashTable.put("Banana", "Price", 100);
        hashTable.put("Banana", "Stock", 30);

        System.out.println("Apple Price: " + hashTable.get("Apple", "Price"));

        System.out.println("HashBasedTable: " + hashTable);
        System.out.println();

        //sorted Table!
        Table<String, String, Integer> treeTable = TreeBasedTable.create();

        treeTable.put("Orange", "Price", 120);
        treeTable.put("Apple", "Price", 150);
        treeTable.put("Apple", "Stock", 50);
        treeTable.put("Banana", "Price", 100);
        treeTable.put("Banana", "Stock", 30);


        System.out.println("Banana Stock: " + treeTable.get("Banana", "Stock")); // Output: 30

        System.out.println("TreeBasedTable: " + treeTable);
    }

    public static void biMapView(){
        /*
        BiMap. In Bimap sind der Wert und der Schlüssel eindeutig(unique)
         */
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("one", 1);
//       biMap.put("onee", 1);  hier kriegt man die Exception,
//        weil der Wert und der Schlüssel müssen eindeutig sein
        biMap.put("two", 2);
        biMap.put("three", 3);
        biMap.put("four", 4);
        System.out.println(biMap);
        System.out.println();
    }



}
