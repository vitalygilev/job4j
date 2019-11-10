package ru.job4j.oop;

public class Predator extends Animal {

    public Predator(String name) {
        super("Animal");
        this.name = name;
        System.out.println(this.name);
    }

}
