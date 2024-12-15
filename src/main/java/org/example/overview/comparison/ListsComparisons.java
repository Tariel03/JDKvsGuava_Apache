package org.example.overview.comparison;

import com.google.common.collect.ImmutableList;
import org.apache.commons.collections4.list.FixedSizeList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Vergleich verschiedener Listentypen mit unterschiedlichen Eigenschaften hinsichtlich Unveränderlichkeit:
 * - ImmutableList (Guava): Vollständig unveränderlich; keine Modifikationen erlaubt.
 * - unmodifiableaList (Java Collections): Nur lesbare Ansicht, Änderungen an der zugrundeliegenden Liste werden übernommen.
 * - FixedSizeList (Apache Commons): Feste Größe, erlaubt jedoch das Ändern von Elementen.
 * - final List (Java): Referenz kann nicht neu zugewiesen werden, Inhalte können jedoch modifiziert werden.
 */
public class ListsComparisons {
    public static void main(String[] args) {
        // ImmutableList: für konstante Konfigurationen oder Daten, die nicht verändert werden sollen
        ImmutableList<String> immutableUsers = ImmutableList.of("Person1", "Person2", "Person3", "Person4");
        System.out.println("ImmutableList: " + immutableUsers);

        // unmodifiableList: nur lesbare Ansicht einer vorhandenen Liste
        List<String> alphabet = new ArrayList<>(List.of("a", "b", "c", "d", "e"));
        List<String> unmodifiableAlphabet = Collections.unmodifiableList(alphabet);
        System.out.println("Unmodifiable List: " + unmodifiableAlphabet);

        // FixedSizeList: erlaubt das Ändern von Elementen, verhindert jedoch das Ändern der Größe
        List<Integer> fixedPrices = FixedSizeList.fixedSizeList(new ArrayList<>(List.of(10, 20, 30, 40)));
        System.out.println("Fixed List: " + fixedPrices);

        // final List: verhindert die Neuzuweisung der Referenz, erlaubt jedoch das Ändern von Elementen
        final List<String> books = new ArrayList<>(List.of("Krieg und Frieden", "Meister und Margarita"));
        System.out.println("final List (änderbare Inhalte): " + books);

        /*
        Test der Hinzufügen-, Entfernen- und Setzen-Operationen für jeden Listentyp:
         */

        // ImmutableList: Hinzufügen von Elementen (wirft UnsupportedOperationException)
        try {
            immutableUsers.add("Person_22");
        } catch (UnsupportedOperationException e) {
            System.out.println("Hinzufügen nicht erlaubt bei ImmutableList: " + immutableUsers);
        }

        // unmodifiableList: Hinzufügen von Elementen (wirft UnsupportedOperationException)
        try {
            unmodifiableAlphabet.add("G");
        } catch (UnsupportedOperationException e) {
            System.out.println("Hinzufügen nicht erlaubt bei unmodifiableList: " + unmodifiableAlphabet);
        }

        // Demonstration, dass Änderungen an der ursprünglichen Liste auch in der unmodifiableList angezeigt werden
        alphabet.add("t");
        System.out.println("Aktualisierte unmodifiableList: " + unmodifiableAlphabet); // Übernimmt Änderungen der Original-Liste

        // FixedSizeList: Hinzufügen von Elementen (wirft UnsupportedOperationException)
        try {
            fixedPrices.add(10);
        } catch (UnsupportedOperationException e) {
            System.out.println("Hinzufügen nicht erlaubt bei FixedSizeList: " + fixedPrices);
        }

        // final List: Hinzufügen von Elementen (erlaubt)
        books.add("Harry Potter");
        System.out.println("final List nach Hinzufügen: " + books);

        /*
        Test der Setzen-Operationen
         */

        // ImmutableList: Setzen von Elementen (wirft UnsupportedOperationException)
        try {
            immutableUsers.set(1, "Person_2");
        } catch (UnsupportedOperationException e) {
            System.out.println("Setzen nicht erlaubt bei ImmutableList: " + immutableUsers);
        }

        // FixedSizeList: Setzen von Elementen (erlaubt)
        System.out.println("Vor der Änderung FixedSizeList: " + fixedPrices);
        fixedPrices.set(1, 21);
        System.out.println("Nach der Änderung FixedSizeList: " + fixedPrices);

        /*
        Test der Entfernen-Operationen
         */

        // ImmutableList: Entfernen von Elementen (wirft UnsupportedOperationException)
        try {
            immutableUsers.remove(1);
        } catch (UnsupportedOperationException e) {
            System.out.println("Entfernen nicht erlaubt bei ImmutableList: " + immutableUsers);
        }

        // FixedSizeList: Entfernen von Elementen (wirft UnsupportedOperationException)
        try {
            fixedPrices.remove(1);
        } catch (UnsupportedOperationException e) {
            System.out.println("Entfernen nicht erlaubt bei FixedSizeList: " + fixedPrices);
        }
    }
}
