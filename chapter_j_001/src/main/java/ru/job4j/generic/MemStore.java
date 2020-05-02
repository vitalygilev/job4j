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
        int curIndex = indexOf(id);
        if (curIndex == -1) {
            return false;
        }
        mem.set(curIndex, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int curIndex = indexOf(id);
        if (curIndex == -1) {
            return false;
        }
        mem.remove(curIndex);
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

    public int indexOf(String id) {
        int result = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }

}