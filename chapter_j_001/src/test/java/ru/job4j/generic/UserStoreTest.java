package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class UserStoreTest {

    @Test
    public void whenAddTest() {
        UserStore users = new UserStore();
        users.add(new User("user1", "mr First"));
        users.add(new User("user2", "mr Second"));
        assertThat(users.findById("user1").getName(), is("mr First"));
    }

    @Test
    public void whenDeleteTest() {
        UserStore users = new UserStore();
        users.add(new User("user1", "mr First"));
        users.add(new User("user2", "mr Second"));
        users.delete("user1");
        assertThat(users.findById("user1"), is(nullValue()));
    }
}