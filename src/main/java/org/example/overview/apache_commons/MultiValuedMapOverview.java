package org.example.overview.apache_commons;


import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//Ähnlich wie Guava Collections MultiMap, MultiValuedMap kann mehr als ein Wert fur den Schlüssel haben.
public class MultiValuedMapOverview {
    public static void main(String[] args) {
        MultiValuedMap<String, String> multiMap = new ArrayListValuedHashMap<>();
        multiMap.put("fruit", "apple");
        multiMap.put("fruit", "banana");
        multiMap.put("fruit", "cherry");
        multiMap.put("vegetable", "carrot");

        //Hier prüft man, ob das Paar von dem Wert und dem Schlüssel wirklich in MultiValuedMap gibt.
        System.out.println(multiMap.containsMapping("fruit", "apple"));
        System.out.println(multiMap);
        //Hier löscht man das Paar von dem Wert und dem Schlüssel.
        System.out.println(multiMap.removeMapping("fruit", "apple"));
        System.out.println(multiMap);
        System.out.println("Fruits: " + multiMap.get("fruit"));  // Output: [banana, cherry]

        System.out.println("All entries: " + multiMap.entries());  // Output: [fruit=banana, fruit=cherry, vegetable=carrot]


    }




}
