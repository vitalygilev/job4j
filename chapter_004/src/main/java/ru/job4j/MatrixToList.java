package ru.job4j;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MatrixToList {
    public static void main(String[] args) {
        Integer[][] matrix = new Integer[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }
        System.out.println(Arrays.stream(matrix).flatMap(e -> Arrays.stream(e)).collect(Collectors.toList()));
    }
}
