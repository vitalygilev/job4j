package ru.job4j.list;

import list.SortUser;
import list.User;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void when3UsersInListSortByNameLength() {

        List<User> users = new ArrayList<>();
        users.addAll(
                Arrays.asList(
                new User(1, "User 1", "Default city", 20),
                new User(2, "User 2.1", "Default city", 34),
                new User(3, "User 3", "Default city", 56))
        );

        List<User> expect = List.of(
                new User(1, "User 1", "Default city", 20),
                new User(3, "User 3", "Default city", 56),
                new User(2, "User 2.1", "Default city", 34)
        );

        assertThat(SortUser.sortNameLength(users), is(expect));
    }

    @Test
    public void when3UsersInListSortByAllFields() {

        List<User> users = new ArrayList<>();
        users.addAll(
                Arrays.asList(
                        new User(1, "User 1", "Default city", 20),
                        new User(2, "User 3", "Default city", 34),
                        new User(3, "User 2", "Default city", 56)
                )
        );

        List<User> expect = List.of(
                new User(1, "User 1", "Default city", 20),
                new User(3, "User 2", "Default city", 56),
                new User(2, "User 3", "Default city", 34)
        );

        assertThat(SortUser.sortByAllFields(users), is(expect));
    }
}
