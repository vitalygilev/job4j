package main.java.ru.job4j.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Converter {

    private List<Integer> items = new ArrayList<>();
    private int index;

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        while (it.hasNext()) {
            Iterator curIter = it.next();
            while (curIter.hasNext()) {
                items.add((Integer) curIter.next());
            }
        }

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index < items.size();
            }

            @Override
            public Integer next() throws NoSuchElementException {
                if (hasNext()) {
                    return items.get(index++);
                } else {
                    index = 0;
                    throw new NoSuchElementException("No more elements in this Iterator!");
                }
            }
        };
    }
}
