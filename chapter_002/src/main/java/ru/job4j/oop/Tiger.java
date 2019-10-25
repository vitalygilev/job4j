package ru.job4j.oop;

public class Tiger extends Predator {

    public Tiger() {
        super("Predator");
        this.name = "Tiger";
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
    }

}
