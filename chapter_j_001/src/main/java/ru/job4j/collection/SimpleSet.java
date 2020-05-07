package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {

    private SimpleArray<T> elements = new SimpleArray<T>();

    public void add(T model) {
        boolean found = false;
        for (T curr : elements) {
            if (curr.equals(model)) {
                found = true;
                break;
            }
        }
        if (!found) {
            elements.add(model);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }


}
