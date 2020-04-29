package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        T curElement = findById(id);
        if (curElement == null) {
            return false;
        }
        mem.set(mem.indexOf(curElement), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        T curElement = findById(id);
        if (curElement == null) {
            return false;
        }
        mem.remove(curElement);
        return true;
    }

    @Override
    public T findById(String id) {
        T resElement = null;
        for (T curElement: mem) {
            if (curElement.getId().equals(id)) {
                resElement = curElement;
                break;
            }
        }
        return resElement;
    }
}