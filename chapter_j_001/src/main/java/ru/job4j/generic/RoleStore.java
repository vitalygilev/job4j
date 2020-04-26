package ru.job4j.generic;

public class RoleStore implements Store<UserRole> {

    private final Store<UserRole> store = new MemStore<>();

    @Override
    public void add(UserRole model) {

    }

    @Override
    public boolean replace(String id, UserRole model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public UserRole findById(String id) {
        return null;
    }
}
