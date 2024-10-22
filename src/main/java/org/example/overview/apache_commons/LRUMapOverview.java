package org.example.overview.apache_commons;

import org.apache.commons.collections4.map.LRUMap;

/*
LRU steht für "Least Recently Used" (auf Deutsch: "Am wenigsten kürzlich verwendet").
Es handelt sich um eine Cache-Strategie, bei der die am längsten nicht verwendeten Einträge zuerst entfernt werden,
wenn der Cache voll ist. Dies wird verwendet, um sicherzustellen, dass die häufigsten und zuletzt verwendeten Daten
im Speicher bleiben.
 */
public class LRUMapOverview {
    // Hier wird eine LRUMap mit einer maximalen Größe von 3 erstellt.
    public static void main(String[] args) {
        // LRUMap kann maximal 3 Elemente speichern.
        LRUMap<String, Integer> lruMap = new LRUMap<>(3);

        // Drei Einträge in die Map einfügen.
        lruMap.put("one", 1);
        lruMap.put("two", 2);
        lruMap.put("three", 3);

        // Ausgabe der Karte, die die drei Einträge zeigt.
        System.out.println("Initial map: " + lruMap);  // Output: {one=1, two=2, three=3}

        // Den Wert des Schlüssels "one" abrufen, um diesen als kürzlich verwendet zu markieren.
        // Dies stellt sicher, dass der Eintrag "one" nicht als ältester Eintrag entfernt wird.
        lruMap.get("one");

        // Einen vierten Eintrag hinzufügen. Da die maximale Kapazität erreicht ist, wird
        // der am wenigsten verwendete Eintrag entfernt. In diesem Fall ist es "two", da es zuletzt
        // verwendet wurde und nicht kürzlich abgerufen wurde.
        lruMap.put("four", 4);

        // Ausgabe der Map nach dem Hinzufügen von "four". Man sieht, dass "two" entfernt wurde,
        // da es der am wenigsten kürzlich verwendete Eintrag war.
        System.out.println("Map after adding 'four': " + lruMap);  // Output: {one=1, three=3, four=4}

        // Erklärung: Der Eintrag "two" wurde entfernt, weil er der am wenigsten verwendete war
        // und "one" durch den vorherigen Abruf als "jüngst verwendet" markiert wurde.

        // Anpassung der LRUMap: Hier wird gezeigt, wie man den "load factor" anpassen kann.

        // Eine neue LRUMap mit einer maximalen Größe von 3 und einem Ladefaktor von 0,75 erstellen.
        /*
        Der Ladefaktor (load factor) bestimmt, wie voll die Map sein kann, bevor versucht wird,
        alte Einträge zu entfernen. In diesem Fall beträgt der Ladefaktor 0,75, was bedeutet,
        dass die Map bis zu 75 % ihrer Kapazität nutzen kann, bevor die Entfernung alter Einträge beginnt.
        */
        lruMap = new LRUMap<>(3, 0.75f);

        // Drei neue Einträge hinzufügen
        lruMap.put("A", 1);
        lruMap.put("B", 2);
        lruMap.put("C", 3);

        // Ausgabe der initialen LRUMap
        System.out.println("Initial LRUMap: " + lruMap);

        // Einen neuen Eintrag "D" hinzufügen, wodurch der älteste Eintrag "A" entfernt wird,
        // da er am längsten nicht verwendet wurde.
        lruMap.put("D", 4);
        System.out.println("After adding 'D': " + lruMap);  // Output: {B=2, C=3, D=4} (A wird entfernt)

        // Einen weiteren Eintrag "E" hinzufügen. Der älteste (am wenigsten verwendete) Eintrag,
        // "B", wird jetzt entfernt.
        lruMap.put("E", 5);
        System.out.println("After adding 'E': " + lruMap);  // Output: {C=3, D=4, E=5} (B wird entfernt)
    }
}
