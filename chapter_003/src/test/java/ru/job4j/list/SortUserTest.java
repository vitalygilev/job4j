package ru.job4j.list;

import list.ConvertList;
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
                        new User(3, "User 3", "Default city", 56)
                )
        );

        String expect = "User 2.1";
        assertThat(SortUser.sortNameLength(users).get(2).getName(), is(expect));
    }

    @Test
    public void when3UsersInListSortByAllFields() {

        List<User> users = new ArrayList<>();
        users.addAll(
                Arrays.asList(
                        new User(1, "User 1", "Default city", 20),
                        new User(2, "User 3", "Default city", 34),
                        new User(3, "User 3", "Default city", 56)
                )
        );

        int expect = 56;
        assertThat(SortUser.sortByAllFields(users).get(2).getAge(), is(expect));
    }
}
