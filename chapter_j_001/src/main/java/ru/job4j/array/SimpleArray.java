package ru.job4j.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterator {

    Object[] objects;
    int index = 0, iteratorIndex = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public void remove(int index) {
        if (objects.length - 1 - index >= 0)
            System.arraycopy(objects, index + 1, objects, index, objects.length - 1 - index);
        objects[objects.length - 1] = null;
    }

    public void set(int index, T model) {
        objects[index] = model;
    }

    public T get(int index) {
        return (T) objects[index];
    }

    @Override
    public boolean hasNext() {
        return iteratorIndex < objects.length;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in this matrix!");
        }
        return objects[iteratorIndex++];
    }

    @Override
    public void remove() {

    }

}
