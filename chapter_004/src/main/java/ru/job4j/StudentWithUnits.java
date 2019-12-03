package ru.job4j;

import java.util.Set;

public class StudentWithUnits {

    private String name;
    private Set<String> units;

    public StudentWithUnits(String name, Set<String> units) {
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public Set<String> getUnits() {
        return units;
    }

}
