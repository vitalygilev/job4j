package ru.job4j.generic;

public class User extends Base {

    private String name;

    protected User(String id) {
        super(id);
    }

    public User(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
