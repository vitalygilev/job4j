package ru.job4j.generic;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {

    @Test
    public void when1Added2Deleted3Changed() {

        Analize.Info res = new Analize.Info(1, 2, 3);
        Analize analyser = new Analize();
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "User 1"),
                new Analize.User(2, "User 2"),
                new Analize.User(3, "User 3"),
                new Analize.User(4, "User 4"),
                new Analize.User(5, "User 5"),
                new Analize.User(6, "User 6"));
        List<Analize.User> current = Arrays.asList(
                new Analize.User(4, "User 4"),
                new Analize.User(5, "User 5.1"),
                new Analize.User(6, "User 6.1"),
                new Analize.User(7, "User 7")
        );

        assertThat(
                analyser.diff(previous, current),
                is(res)
        );
    }


}