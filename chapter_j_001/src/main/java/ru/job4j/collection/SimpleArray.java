package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] elementData;
    private static final int INITIAL_SIZE = 10;
    private int currentSize = INITIAL_SIZE;
    private long modCount = 0;
    private int currentIndex = 0;

    public SimpleArray() {
        elementData = new Object[INITIAL_SIZE];
    }

    public T get(int index) {
        Objects.checkIndex(index, currentSize);
        return (T) elementData[index];
    }

    public void add(T model) {
        if (currentIndex == currentSize) {
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

        return new Iterator<>() {

            long expectedModCount = modCount;
            int currentIteratorIndex = 0;

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
    }
}