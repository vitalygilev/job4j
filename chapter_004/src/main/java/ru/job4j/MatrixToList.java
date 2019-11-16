package ru.job4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixToList {

    static Integer[][] matrix = new Integer[10][10];

    public static List<Integer> matrixToList(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(e -> Arrays.stream(e)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                matrix[i][j] = (i + 1) * (j + 1);
            }
        }
        System.out.println(matrixToList(matrix));
    }
}
