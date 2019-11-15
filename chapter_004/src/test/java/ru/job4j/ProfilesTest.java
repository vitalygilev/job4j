package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    public List<Profile> profiles = new ArrayList<>();

    @Before
    public void init() {
        profiles.add(new Profile(new Address("Default City 1", "Default street 1", 1, 1)));
        profiles.add(new Profile(new Address("Default City 3", "Default street 3", 3, 3)));
        profiles.add(new Profile(new Address("Default City 3", "Default street 3", 3, 3)));
        profiles.add(new Profile(new Address("Default City 3", "Default street 3", 3, 3)));
        profiles.add(new Profile(new Address("Default City 2", "Default street 2", 2, 2)));
    }

    @Test
    public void whenAddressList() {

        List<Address> expect = Arrays.asList(
                new Address("Default City 1", "Default street 1", 1, 1),
                new Address("Default City 2", "Default street 2", 2, 2),
                new Address("Default City 3", "Default street 3", 3, 3)
        );
        assertThat(Profiles.collect(profiles), is(expect));
    }
}
