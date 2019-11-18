package ru.job4j.list;

import list.ConvertList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
    @Test
    public void when2ArraysInList() {

        List<int[]> list = List.of(new int[]{1, 2}, new int[]{3, 4, 5, 6});
        List<Integer> result = ConvertList.convert(list);

        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }
}
