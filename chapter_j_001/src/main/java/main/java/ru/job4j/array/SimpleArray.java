package main.java.ru.job4j.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterator {

    private Object[] objects;
    private int index = 0;
    private int iteratorIndex = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public void remove(int position) throws NoSuchElementException {
        if  (position >= index || position < 0) {
            throw new NoSuchElementException("There is no such element!");
        }
        System.arraycopy(objects, position + 1, objects, position, index - position - 1);
        if (index < objects.length) {
            objects[index--] = null;
        } else {
            objects[--index] = null;
        }
    }

    public void set(int position, T model) throws NoSuchElementException {
        if (position < 0 || position > index) {
            throw new NoSuchElementException("There is no such element!");
        }
        objects[position] = model;
    }

    public T get(int index) throws NoSuchElementException {
        if (index < 0 || index >= objects.length) {
            throw new NoSuchElementException("There is no such element!");
        }
        return (T) objects[index];
    }

    @Override
    public boolean hasNext() {
        return iteratorIndex < objects.length;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in this array!");
        }
        return objects[iteratorIndex++];
    }

    @Override
    public void remove() {

    }

}
