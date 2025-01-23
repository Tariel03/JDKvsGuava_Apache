package org.example.overview.guava;

import com.google.common.collect.*;
import com.google.errorprone.annotations.Immutable;

import java.util.*;

public class GuavaOverview {
    public static void main(String[] args) {
//        immutableView();
//        multiMapView();
//        multiSetView();
        tableOverview();
//        biMapView();


    }

    public static void immutableView(){
        //Immutable List!
        ImmutableList<String> immutableList = ImmutableList.of("apple", "banana", "tomato");
        System.out.println(immutableList);

        try {
            immutableList.add("orange");  // Hier gibt die Programme UnsupportedOperationException, weil ImmutableSet ist unveränderbar.
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify an ImmutableSet!");
        }


    }

    public static void multiMapView(){

        Multimap<String, String> multimap = ArrayListMultimap.create();

        multimap.put("fruit", "apple");
        multimap.put("fruit", "banana");
        multimap.put("fruit", "cherry");
        multimap.put("vegetable", "carrot");
        System.out.println("Fruits: " + multimap.get("fruit")); //Ausgabe : Fruits: [apple, banana, cherry]


    }


    public static void multiSetView(){
        Multiset<Integer> multiset = HashMultiset.create();
        multiset.addAll(List.of(1, 2, 3, 4, 5, 6, 6, 2, 1, 1));
        System.out.println("There are " + multiset.count(1) + " times, 1 was found in the multiset!"); //Ausgabe:There are 3 times, 1 was found in the multiset!
    }
    public static void tableOverview() {
        Table<String, String, Integer> hashTable = HashBasedTable.create();
        hashTable.put("Apple", "Price", 150);
        hashTable.put("Apple", "Stock", 50);
        hashTable.put("Banana", "Price", 100);
        hashTable.put("Banana", "Stock", 30);

        System.out.println("Apple Price: " + hashTable.get("Apple", "Price")); //Ausgabe : Apple Price: 150

        //Let's check if null values are supported!
        hashTable.put("Apple", null, 10);
//        System.out.println(hashTable.get(null,null));
    }


    public static void biMapView(){
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("one", 1);
        biMap.put("two", 2);
        biMap.put("three", 3);
        biMap.put("four", 4);
        System.out.println("Key for value two: " + biMap.get("two")); // Ausgabe: 2
        try{
            biMap.put("quadro",4);

        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());//
        }

    }



}
