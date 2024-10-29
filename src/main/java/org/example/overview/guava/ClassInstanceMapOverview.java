package org.example.overview.guava;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

import java.util.Scanner;


//ClassInstanceMap ist ein Map, der enthält Class als Schlüssel und Objekt als Wert.
public class ClassInstanceMapOverview {
    public static void main(String[] args) {
        // ClassToInstanceMap for numbers
        ClassToInstanceMap<Number> classToInstanceMap = MutableClassToInstanceMap.create();
        classToInstanceMap.putInstance(Integer.class, 123);
        classToInstanceMap.putInstance(Double.class, 45.67);

        System.out.println("Integer instance: " + classToInstanceMap.getInstance(Integer.class));
        System.out.println("Double instance: " + classToInstanceMap.getInstance(Double.class));

        // ClassToInstanceMap for animals
        ClassToInstanceMap<Animal> animalClassToInstanceMap = MutableClassToInstanceMap.create();
        animalClassToInstanceMap.putInstance(Cat.class, new Cat("Garfield", 10));  // Speichert als Cat.class
        animalClassToInstanceMap.putInstance(Dog.class, new Dog("Goofy", 50));     // Speichert als Dog.class

        System.out.println("Cat instance: " + animalClassToInstanceMap.getInstance(Cat.class));
        System.out.println("Dog instance: " + animalClassToInstanceMap.getInstance(Dog.class));

        /*
        So, kann man ClassToInstanceMap unterschiedlich benutzen. Hier muss eine Zahlung-Applikation entwickeln, in der
        gibt es unterschiedliche Zahlung-Arten: Bargeld, Visa, Paypal. Man kann ClassToInstanceMap verwenden um sicherzu-
        stellen, das man kann bezahlen, ohne sich Sorge zu machen.
         */
        ClassToInstanceMap<Payment> paymentMap = MutableClassToInstanceMap.create();
        paymentMap.putInstance(Paypal.class, new Paypal());
        paymentMap.putInstance(Card.class, new Card());
        paymentMap.putInstance(Cash.class, new Cash());

        Scanner scanner = new Scanner(System.in);
        Payment payment;

        boolean flag = true;
        while (flag) {
            System.out.println("Willkommen im Zahlungssystem. Bitte wählen Sie eine Zahlungsart:" +
                    "\n1: Paypal" +
                    "\n2: Karte" +
                    "\n3: Barzahlung" +
                    "\n0: Beenden");

            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    payment = paymentMap.get(Paypal.class);
                    payment.paying();
                    break;
                case 2:
                    payment = paymentMap.get(Card.class);
                    payment.paying();
                    break;
                case 3:
                    payment = paymentMap.get(Cash.class);
                    payment.paying();
                    break;
                case 0:
                    flag = false;
                    System.out.println("Zahlungssystem wird beendet. Auf Wiedersehen!");
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
            }
        }
        scanner.close();
    }
}

interface Payment {
    void paying();
    Scanner scanner = new Scanner(System.in);
}

// Paypal-Zahlung mit zusätzlichem Authentifizierungsschritt
class Paypal implements Payment {

    @Override
    public void paying() {
        System.out.println("Bitte geben Sie Ihre Paypal-E-Mail zur Authentifizierung ein:");
        String email = scanner.nextLine();
        System.out.println("Bitte geben Sie Ihr Passwort ein:");
        String password = scanner.nextLine();
        System.out.println("Paypal-Authentifizierung erfolgreich für E-Mail: " + email);
        System.out.println("Die Zahlung wird innerhalb einer Stunde über Paypal bearbeitet.");
    }
}

// Kartenzahlung mit Kartennummer- und CVV-Verifizierung
class Card implements Payment {

    @Override
    public void paying() {
        System.out.println("Bitte geben Sie Ihre Kartennummer ein:");
        long cardNumber = scanner.nextLong();
        System.out.println("Bitte geben Sie Ihren CVV ein:");
        int cvv = scanner.nextInt();
        System.out.println("Karte mit der Endung " + (cardNumber % 10000) + " wurde verifiziert.");
        System.out.println("Die Zahlung wird innerhalb einer Stunde über Ihre Karte bearbeitet.");
    }
}

// Barzahlungsmethode mit Offline-Prozessanweisungen
class Cash implements Payment {
    @Override
    public void paying() {
        System.out.println("Barzahlung ausgewählt. Bitte besuchen Sie unser nächstes Büro, um die Zahlung abzuschließen.");
        System.out.println("Büro-Adresse: N Land, N Straße 31-4, 44444, geöffnet von Montag bis Freitag, 9 bis 17 Uhr.");
    }
}
class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
}
