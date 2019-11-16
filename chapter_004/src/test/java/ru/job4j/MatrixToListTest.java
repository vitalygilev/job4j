package ru.job4j;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixToListTest {
    @Test
    public void whenMatrixToList() {
        List<Integer> expect = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                expect.add((i + 1) * (j + 1));
            }
        }

        Integer[][] matrix = new Integer[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }
        assertThat(MatrixToList.matrixToList(matrix), is(expect));
    }
}
