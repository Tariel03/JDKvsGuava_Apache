package org.example.overview.apache_commons;

import org.apache.commons.collections4.list.FixedSizeList;
import org.apache.commons.collections4.*;
import org.apache.commons.collections4.map.FixedSizeMap;


import java.util.*;

//Ähnlich wie ImmutableList erzeugt die ist und Map, die unveränderbar sind.
public class FixedSizeOverview {
    public static void main(String[] args) {
        fixedListOverview();
        fixedMapOverview();

    }
    public static void fixedListOverview(){
        List<String> list = FixedSizeList.fixedSizeList(List.of("apple", "orange", "mango", "banana"));
        System.out.println(list);

        try{
            list.set(1,"watermelon");
            System.out.println(list);
        }catch (UnsupportedOperationException exception){
            System.out.println("The list can't be changed");
        }
        //Hinzufügen die Dateien in FixedList
        try{
            list.add("strawberry");
            System.out.println(list);
        }catch (UnsupportedOperationException exception){
            System.out.println("An element can't be added to fixedList");
        }
        //Hinzufügen die Dateien in FixedList
        try{
            list.remove("strawberry");
            System.out.println(list);
        }catch (UnsupportedOperationException exception){
            System.out.println("An element can't be deleted from fixedList");
        }
        System.out.println();

    }
    public static void fixedMapOverview(){
        // Create a fixed-size map from an existing map
        Map<String, Integer> map = FixedSizeMap.fixedSizeMap(new HashMap<>(Map.of("apple", 1, "banana", 2, "cherry", 3)));

        System.out.println("Original map: " + map);  // Output: {apple=1, banana=2, cherry=3}



        try {
            map.put("grape", 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot add to a fixed-size map!");  // Output: Cannot add to a fixed-size map!
        }

        try {
            map.remove("apple");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot remove from a fixed-size map!");  // Output: Cannot remove from a fixed-size map!
        }
        System.out.println();
    }
}
