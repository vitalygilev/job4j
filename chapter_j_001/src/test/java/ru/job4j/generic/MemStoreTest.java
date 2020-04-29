package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class MemStoreTest {

    @Test
    public void testAdd() {
        MemStore mem = new MemStore();
        mem.add(new User("m1"));
        mem.add(new User("m2"));
        assertThat(mem.findById("m1").getId(), is("m1"));
    }

    @Test
    public void testReplace() {
        MemStore mem = new MemStore();
        mem.add(new User("m1"));
        mem.add(new User("m2"));
        mem.replace("m1", new User("m3"));
        assertThat(mem.findById("m1"), is(nullValue()));
    }

    @Test
    public void testDelete() {
        MemStore mem = new MemStore();
        mem.add(new UserRole("m1"));
        mem.add(new UserRole("m2"));
        mem.delete("m1");
        assertThat(mem.findById("m1"), is(nullValue()));
    }

}