package ru.job4j.collection;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HashMapTest {

    @Test
    public void whenDuplicates() {

        User user1 = new User("User1", 1, new GregorianCalendar(1980, Calendar.JANUARY, 25));
        User user2 = new User("User1", 1, new GregorianCalendar(1980, Calendar.JANUARY, 25));

        HashMap<User, Object> map = new HashMap<>();
        map.insert(user1, "User1");
        map.insert(user2, "User2");

        assertThat(map.get(user2), is("User2"));
    }

    @Test
    public void whenIterator() {

        HashMap<Integer, String> map = new HashMap<>();
        map.insert(1, "User1");
        map.insert(2, "User2");
        Iterator<String> iterator = map.iterator();
        StringBuilder res = new StringBuilder();
        while (iterator.hasNext()) {
            res.append(iterator.next());
        }

        assertThat(res.toString(), is("User1User2"));
    }

    @Test
    public void whenDelete() {

        HashMap<Integer, String> map = new HashMap<>();
        map.insert(1, "User1");
        map.insert(2, "User2");
        map.delete(1);
        Iterator<String> iterator = map.iterator();
        StringBuilder res = new StringBuilder();
        while (iterator.hasNext()) {
            res.append(iterator.next());
        }

        assertThat(res.toString(), is("User2"));
    }
}