package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] elementData;
    private static final int INITIAL_SIZE = 10;
    private int currentSize = INITIAL_SIZE;
    private long modCount = 0;
    private long expectedModCount;
    private int currentIndex = 0;
    private int currentIteratorIndex = 0;

    public SimpleArray() {
        elementData = new Object[INITIAL_SIZE];
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentIndex) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
        return (T) elementData[index];
    }

    public void add(T model) {
        try {
            Objects.checkIndex(currentIndex + 1, currentSize);
        } catch (IndexOutOfBoundsException  e) {
            grow();
        }
        modCount++;
        elementData[currentIndex++] = model;
    }

    private void grow() {
        currentSize = currentSize + currentSize >> 1;
        elementData = Arrays.copyOf(elementData, currentSize);
    }

    @Override
    public Iterator<T> iterator() {

        Iterator<T> iterator = new Iterator<>() {

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                return currentIteratorIndex < currentIndex;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) elementData[currentIteratorIndex++];
            }
        };
        expectedModCount = modCount;
        return iterator;
    }
}