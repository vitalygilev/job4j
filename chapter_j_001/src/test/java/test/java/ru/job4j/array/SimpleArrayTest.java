package test.java.ru.job4j.array;

import org.junit.Test;
import main.java.ru.job4j.array.SimpleArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SimpleArrayTest {

    @Test
    public void whenAddGetFirstElement() {
        SimpleArray<Integer> elements = new SimpleArray<>(2);
        elements.add(2);
        assertThat(elements.get(0), is(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddGetAbsentElement() {
        SimpleArray<Integer> elements = new SimpleArray<>(1);
        elements.add(2);
        elements.get(1);
    }

    @Test
    public void whenDeleteFirstElement() {
        SimpleArray<String> elements = new SimpleArray<>(2);
        elements.add("1");
        elements.add("2");
        elements.remove(0);
        assertThat(elements.get(0), is("2"));
    }

    @Test
    public void whenDeleteLastElement() {
        SimpleArray<String> elements = new SimpleArray<>(2);
        elements.add("1");
        elements.add("2");
        elements.remove(1);
        assertThat(elements.get(0), is("1"));
    }

    @Test
    public void serialReading() {
        SimpleArray<Integer> elements = new SimpleArray<>(2);
        elements.add(1);
        elements.add(2);
        Iterator<Integer> it = elements.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

}
