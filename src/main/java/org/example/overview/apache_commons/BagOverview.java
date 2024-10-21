package org.example.overview.apache_commons;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

/*
Bag basiert auf Idee, dass man kann rechnen wie viele gleiche Elemente in den "Bag" Speicherplatz sind.
 */
public class BagOverview {
    public static void main(String[] args) {
        Bag<String> bag = new HashBag<>();
        bag.add("butter",3);
        bag.add("bread");
        bag.add("dog");
        bag.add("cat");
        bag.add("tiger");
        bag.add("apple",2);
        System.out.println(bag);

        System.out.println(bag.contains("bread"));
        System.out.println("The number of occurrences of word butter is: "+ bag.getCount("butter"));
        System.out.println(bag.remove("butter",1));
        System.out.println("The number of occurrences of word butter is: "+ bag.getCount("butter"));
        System.out.println(bag.uniqueSet());
        System.out.println();

        //Treebag speichert die Daten sortiert!
        bag = new TreeBag<>();
        bag.add("butter",3);
        bag.add("bread");
        bag.add("dog");
        bag.add("cat");
        bag.add("tiger");
        bag.add("apple",2);
        System.out.println(bag);
        System.out.println(bag.contains("bread"));
        System.out.println("The number of occurrences of word butter is: "+ bag.getCount("butter"));
        System.out.println(bag.remove("butter",1));
        System.out.println("The number of occurrences of word butter is: "+ bag.getCount("butter"));
        System.out.println(bag.uniqueSet());
        System.out.println();


    }
}
