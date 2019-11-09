package ru.job4j.list;

import list.User;
import list.UserConvert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void when3UsersInList() {

        HashMap<Integer, User> result = UserConvert.process(Arrays.asList(new User(1, "User 1", "Default City", 20),
                                                                          new User(2, "User 2", "Default City", 20),
                                                                          new User(3, "User 3", "Default City", 20)
                ));
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, new User(1, "User 1", "Default City", 20));
        expect.put(2, new User(2, "User 2", "Default City", 20));
        expect.put(3, new User(3, "User 3", "Default City",20));
        assertThat(result, is(expect));
    }
}
