package org.example.overview.guava;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;


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
