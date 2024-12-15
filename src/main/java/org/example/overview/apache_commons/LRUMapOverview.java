package org.example.overview.apache_commons;

import org.apache.commons.collections4.map.LRUMap;

/*
LRU steht für "Least Recently Used" (auf Deutsch: "Am wenigsten kürzlich verwendet").
Es handelt sich um eine Cache-Strategie, bei der die am längsten nicht verwendeten Einträge zuerst entfernt werden,
wenn der Cache voll ist. Dies wird verwendet, um sicherzustellen, dass die häufigsten und zuletzt verwendeten Daten
im Speicher bleiben.
 */
public class LRUMapOverview {
    public static void main(String[] args) {
        LRUMap<String, Integer> lruMap = new LRUMap<>(3);
        lruMap.put("one", 1);
        lruMap.put("two", 2);
        lruMap.put("three", 3);
        System.out.println("Initial map: " + lruMap);  //Ausgabe: {one=1, two=2, three=3}
        lruMap.put("four", 4);
        System.out.println("Map after adding 'four': " + lruMap);  //Ausgabe: {one=1, three=3, four=4}
    }
}
