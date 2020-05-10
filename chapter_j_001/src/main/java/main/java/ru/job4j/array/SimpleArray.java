package main.java.ru.job4j.array;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        objects = new Object[size + 1];
    }

    public void add(T model) throws IndexOutOfBoundsException {
        this.objects[index++] = model;
    }

    public void remove(int position) {
        Objects.checkIndex(position, index);
        System.arraycopy(objects, position + 1, objects, position, index - position - 1);
        objects[index--] = null;
    }

    public void set(int position, T model) {
        Objects.checkIndex(position, index);
        objects[position] = model;
    }

    public T get(int position) {
        Objects.checkIndex(position, index);
        return (T) objects[position];
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {

            int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                return iteratorIndex < index;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in this array!");
                }
                return (T) objects[iteratorIndex++];
            }
        };
    }
}

