package ru.job4j.generic;

public class UserRole extends Base {

    private String name;
    private String description;

    protected UserRole(String id) {
        super(id);
    }

    public UserRole(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
