package ru.job4j.collection;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapTest {

    @Test
    public void map() {

        User user1 = new User("User1", 1, new GregorianCalendar(1980, Calendar.JANUARY, 25));
        User user2 = new User("User1", 1, new GregorianCalendar(1980, Calendar.JANUARY, 25));

        Map<User, Object> map = new HashMap<>();
        map.put(user1, "User1");
        map.put(user2, "User2");

        System.out.println(map);

    }



}
