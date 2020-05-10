package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {

    private SimpleArray<T> elements = new SimpleArray<T>();

    public void add(T model) {
        if (!exists(model)) {
            elements.add(model);
        }
    }

    public boolean exists(T model) {
        boolean result = false;
        for (T curr : elements) {
            if (curr.equals(model)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }


}
