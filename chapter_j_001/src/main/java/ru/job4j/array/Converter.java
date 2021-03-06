package ru.job4j.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    private Iterator<Integer> curIter;

    public Iterator<Integer> convert(final Iterator<Iterator<Integer>> it) {

        curIter = it.next();

        return new Iterator<Integer>() {
            @SuppressWarnings("checkstyle:LeftCurly")
            @Override
            public boolean hasNext() {
                while (!curIter.hasNext()) {
                    if (it.hasNext()) {
                        curIter = it.next();
                    } else {
                        break;
                    }
                }
                return curIter.hasNext();
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in this Iterator!");
                }
                return curIter.next();
            }

            @Override
            public void remove() {

            }
        };
    }
}
