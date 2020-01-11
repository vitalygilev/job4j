package main.java.ru.job4j.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator {

    private final int[] numbers;
    private int index = 0;

    public EvenIt(int[] numbers) {
        this.numbers = numbers;
    }

    private boolean findNextEven() {
        boolean result = false;
        while (index < numbers.length) {
            if (numbers[index] % 2 == 0) {
                result = true;
                break;
            }
            index++;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return findNextEven();
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!findNextEven()) {
            index = 0;
            throw new NoSuchElementException("No more elements in this array!");
        }
        return numbers[index++];
    }
}
