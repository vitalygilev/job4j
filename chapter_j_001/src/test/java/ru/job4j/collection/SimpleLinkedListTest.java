package ru.job4j.collection;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinkedListTest {

    @Test
    public void whenAddThenGet() {
        SimpleLinkedList<String> testList = new SimpleLinkedList<>();
        testList.add("first");
        String rsl = testList.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleLinkedList<String> testList = new SimpleLinkedList<>();
        testList.add("first");
        String rsl = testList.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleLinkedList<String> testList = new SimpleLinkedList<>();
        testList.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleLinkedList<String> testList = new SimpleLinkedList<>();
        testList.add("first");
        testList.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleLinkedList<String> testList = new SimpleLinkedList<>();
        testList.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinkedList<String> testList = new SimpleLinkedList<>();
        testList.add("first");
        Iterator<String> it = testList.iterator();
        testList.add("second");
        it.next();
    }

}