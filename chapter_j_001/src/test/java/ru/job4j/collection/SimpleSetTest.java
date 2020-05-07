package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void whenAddThenRead() {
        SimpleSet<String> array = new SimpleSet<>();
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("second");
        array.add("second");
        StringBuilder result = new StringBuilder();
        for (String curValue : array) {
            result.append(curValue);
        }
        assertThat(result.toString(), is("firstsecondthird"));
    }

}