package ru.job4j.generic;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class RoleStoreTest {

    @Test
    public void testAdd() {
        RoleStore roles = new RoleStore();
        roles.add(new UserRole("r1", "Role 1", "admin"));
        roles.add(new UserRole("r2", "Role 2", "user"));
        assertThat(roles.findById("r1").getName(), is("Role 1"));
    }

    @Test
    public void testReplace() {
        RoleStore roles = new RoleStore();
        roles.add(new UserRole("r1", "Role 1", "admin"));
        roles.replace("r1", new UserRole("r3", "Role 3", "dummy"));
        assertThat(roles.findById("r1"), is(nullValue()));
    }

    @Test
    public void testDelete() {
        RoleStore roles = new RoleStore();
        roles.add(new UserRole("r1", "Role 1", "admin"));
        roles.delete("r1");
        assertThat(roles.findById("r1"), is(nullValue()));
    }

}