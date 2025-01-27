package org.example.overview.apache_commons;

import org.apache.commons.collections4.map.LRUMap;

/**
 * LRU steht für "Least Recently Used" (auf Deutsch: "Am wenigsten kürzlich verwendet").
 * Es handelt sich um eine Cache-Strategie, bei der die am längsten nicht verwendeten Einträge zuerst entfernt werden,
 * wenn der Cache voll ist. Dies wird verwendet, um sicherzustellen, dass die häufigsten und zuletzt verwendeten Daten
 * im Speicher bleiben.
 */
public class LRUMapOverview {
    private LRUMap<String, Integer> lruMap;

    public LRUMapOverview(int capacity) {
        this.lruMap = new LRUMap<>(capacity);
    }

    /**
     * Fügt einen neuen Eintrag hinzu und entfernt automatisch den am wenigsten verwendeten, falls nötig.
     */
    public void addEntry(String key, Integer value) {
        lruMap.put(key, value);
        System.out.println("Map after adding '" + key + "': " + lruMap);
    }

    /**
     * Holt einen Wert aus der Map, falls er existiert, und aktualisiert die Zugriffsreihenfolge.
     */
    public Integer getEntry(String key) {
        Integer value = lruMap.get(key);
        System.out.println("Accessed key '" + key + "': " + (value != null ? value : "Not found"));
        return value;
    }

    /**
     * Gibt die aktuelle Kapazität und den Inhalt der Map aus.
     */
    public void printCacheState() {
        System.out.println("Current LRU Cache: " + lruMap);
    }

    /**
     * Gibt die aktuelle Größe des Caches zurück.
     */
    public int getCacheSize() {
        return lruMap.size();
    }

    public static void main(String[] args) {
        LRUMapOverview lruCache = new LRUMapOverview(3);

        // Demonstration der Funktionen
        lruCache.addEntry("one", 1);
        lruCache.addEntry("two", 2);
        lruCache.addEntry("three", 3);
        lruCache.printCacheState();

        // Neuen Eintrag hinzufügen - ältester Eintrag wird entfernt
        lruCache.addEntry("four", 4);
        lruCache.printCacheState();

        // Zugriff auf ein Element, um es als kürzlich verwendet zu markieren
        lruCache.getEntry("two");
        lruCache.printCacheState();
    }
}
