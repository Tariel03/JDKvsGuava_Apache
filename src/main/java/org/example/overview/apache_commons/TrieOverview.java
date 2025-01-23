package org.example.overview.apache_commons;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;

import java.util.Map;

/*
Ein Trie, auch Präfix baum genannt, ist eine baumartige Datenstruktur, die zum effizienten Speichern und Abrufen von Schlüsseln in einem Datensatz von
Zeichenfolgen verwendet wird. Der Hauptvorteil eines Versuchs besteht darin, dass er eine schnelle Suche basierend auf Präfixen ermöglicht, was ihn ideal für
                        Anwendungsfälle wie Autocomplete-Systeme, Wörterbuchsuchen oder jede Anwendung macht, bei der ein präfix basierter Abruf erforderlich ist.
 */
public class TrieOverview {
    public static void main(String[] args) {
        basicOverview();
//        autoCompleteOverview();
//        orderedTrieOverview();


    }
    public static void basicOverview(){
        Trie<String, String> trie = new PatriciaTrie<>();
        trie.put("apple", "fruit");
        trie.put("applet", "small fruit");
        trie.put("banana", "fruit");
        trie.put("ball", "toy");
        trie.put("bat", "sports equipment");
        System.out.println("Entries starting with 'app': " + trie.prefixMap("app")); //Ausgabe: {apple=fruit, applet=small fruit}
        System.out.println("Entries starting with 'ba': " +trie.prefixMap("ba"));//Ausgabe:{ball=toy, banana=fruit, bat=sports equipment}
    }
    public static void autoCompleteOverview(){

        //Man kann auch automatische AutoComplete(automatische Vervollständigung) with Trie erzeugen.
        Trie<String, String> autocompleteTrie = new PatriciaTrie<>();

        // Adding some words with their descriptions
        autocompleteTrie.put("apple", "A fruit");
        autocompleteTrie.put("apricot", "Another type of fruit");
        autocompleteTrie.put("banana", "A yellow fruit");
        autocompleteTrie.put("blueberry", "A small blue fruit");
        autocompleteTrie.put("blackberry", "A type of fruit or phone");

        // Simulating an autocomplete by typing the prefix "bl"
        Map<String, String> suggestions = autocompleteTrie.prefixMap("bl");
        System.out.println("Autocomplete suggestions for 'bl': " + suggestions);
        // Output: {blackberry=A type of fruit or phone, blueberry=A small blue fruit}

    }
    public static void orderedTrieOverview(){
        Trie<String, String> trie = new PatriciaTrie<>();
        //Trie<Long, Long> longLongTrie = new PatriciaTrie<>(); not allowed as Key is not String!.

        // Adding key-value pairs
        trie.put("dog", "animal");
        trie.put("cat", "animal");
        trie.put("dolphin", "mammal");
        trie.put("duck", "bird");

        // Printing all keys in lexicographical order
        System.out.println("All keys in sorted order: " + trie.keySet());
        // Output: [cat, dog, dolphin, duck]

        // Retrieving keys within a specific range
        System.out.println("Keys between 'dog' and 'duck': " + trie.subMap("dog", "duck").keySet());
        // Output: [dog, dolphin]
    }



}
