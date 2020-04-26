package main.java.ru.job4j.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int indexI = 0, indexJ = 0;

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return indexJ != values.length - 1 || indexI != values[indexJ].length;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in this matrix!");
        }
        if (indexI == values[indexJ].length) {
            indexI = 0;
            indexJ++;
        }
        return values[indexJ][indexI++];
    }

    @Override
    public void remove() {

    }
}
