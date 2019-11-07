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

        HashMap<Integer, User> result = UserConvert.process(Arrays.asList(new User(1, "User 1", "Default City"),
                                                                          new User(2, "User 2", "Default City"),
                                                                          new User(3, "User 3", "Default City")
                ));
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, new User(1, "User 1", "Default City"));
        expect.put(2, new User(2, "User 2", "Default City"));
        expect.put(3, new User(3, "User 3", "Default City"));
        assertThat(result, is(expect));
    }
}
