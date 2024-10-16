package org.example.overview.guava;

import com.google.common.collect.*;
import com.google.errorprone.annotations.Immutable;

import java.util.*;

public class Overview {
    public static void main(String[] args) {
        /*
         *  Immutable Speicherplätzen, bedeutet dass, man nichts verändern, hinzufüngen oder löschen kann.
         */
        //Immutable List!
        ImmutableList<String> immutableList = ImmutableList.of("apple", "banana", "tomato");
        System.out.println(immutableList);

        //Immutable Set
        Set<Integer> set  = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        set.add(34);
        System.out.println(set);
        set.remove(34);
        System.out.println(set);
        ImmutableSet<Integer> integerImmutableSet = ImmutableSet.of(1,2,3,4,5,6);
        System.out.println(integerImmutableSet);

        /*
        Es gibt viele verschiedene Immutable Classes und Schnittstellen, wie ImmutableSortedSet oder
        ImmutableTable, um unverändernbar Elementen zu erzeugen. Man kann benötigen ,wenn es Daten gibt
        die nicht verändern

         */



        /*
        Man benutzt MultiMap interface um die Funktionalität von JDK-Map zu vergrößern.

         */

        //ArrayListMultiMap speichert die Werte von einen Schlüssel in ArrayList
        Multimap<String, String> multimap = ArrayListMultimap.create();

        multimap.put("fruit", "apple");
        multimap.put("fruit", "banana");
        multimap.put("fruit", "cherry");
        multimap.put("vegetable", "carrot");

        System.out.println("Fruits: " + multimap.get("fruit"));
        System.out.println("All entries: " + multimap.entries());
        System.out.println();


        //beim HashMultiMap speichert man alle Elementen(Schlüssel: [] → Werte in HashSet!
        multimap = HashMultimap.create();

        multimap.put("dog", "bulldog");
        multimap.put("dog", "chihuahua");
        multimap.put("dog", "corgi");
        multimap.put("cat", "bald cat");

        System.out.println("Dogs : " + multimap.get("dog"));
        System.out.println("All entries: " + multimap.entries());
        System.out.println();



        multimap = LinkedHashMultimap.create();

        multimap.put("dog", "bulldog");
        multimap.put("dog", "chihuahua");
        multimap.put("dog", "corgi");
        multimap.put("cat", "bald cat");
        multimap.put("cat", "lion");


        System.out.println("Dogs : " + multimap.get("dog"));
        System.out.println("All entries: " + multimap.entries());







    }
}
