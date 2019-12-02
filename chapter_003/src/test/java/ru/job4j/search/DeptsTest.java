package ru.job4j.search;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DeptsTest {

    @Test
    public void whenIncSort() {

        Depts deptsStruc = new Depts(true);
        deptsStruc.addDept("K1\\SK1");
        deptsStruc.addDept("K1\\SK2");
        deptsStruc.addDept("K1\\SK1\\SSK1");
        deptsStruc.addDept("K1\\SK1\\SSK2");
        deptsStruc.addDept("K2");
        deptsStruc.addDept("K2\\SK1\\SSK1");
        deptsStruc.addDept("K2\\SK1\\SSK2");

        List<String> expect = List.of("K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2","K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2");

        assertThat(deptsStruc.getDepts().toArray(), is(expect.toArray()));
    }

    @Test
    public void whenDescSort() {

        Depts deptsStruc = new Depts(false);
        deptsStruc.addDept("K1\\SK1");
        deptsStruc.addDept("K1\\SK2");
        deptsStruc.addDept("K1\\SK1\\SSK1");
        deptsStruc.addDept("K1\\SK1\\SSK2");
        deptsStruc.addDept("K2");
        deptsStruc.addDept("K2\\SK1\\SSK1");
        deptsStruc.addDept("K2\\SK1\\SSK2");

        List<String> expect = List.of("K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K2\\SK1", "K2",
                "K1\\SK2",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1", "K1");

        assertThat(deptsStruc.getDepts().toArray(), is(expect.toArray()));
    }

}
