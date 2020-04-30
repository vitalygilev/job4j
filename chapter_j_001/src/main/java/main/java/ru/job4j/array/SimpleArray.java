package main.java.ru.job4j.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterator {

    private Object[] objects;
    private int index = 0;
    private int iteratorIndex = 0;

    public SimpleArray(int size) {
        objects = new Object[size + 1];
    }

    public void add(T model) throws IndexOutOfBoundsException {
        if (index == objects.length - 1) {
            throw new IndexOutOfBoundsException("Array overflow!");
        }
        this.objects[index++] = model;
    }

    public void remove(int position) throws IndexOutOfBoundsException {
        if  (position < 0 || position >= index) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        System.arraycopy(objects, position + 1, objects, position, index - position - 1);
        objects[index--] = null;
    }

    public void set(int position, T model) throws IndexOutOfBoundsException {
        if (position < 0 || position >= index) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        objects[position] = model;
    }

    public T get(int position) throws IndexOutOfBoundsException {
        if (position < 0 || position >= index) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return (T) objects[position];
    }

    @Override
    public boolean hasNext() {
        return iteratorIndex <= index;
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
