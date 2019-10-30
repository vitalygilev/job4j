package ru.job4j.array;

import java.util.Arrays;

public class Merge {

    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int leftPosition = 0, rightPosition = 0;
        while (leftPosition + rightPosition < rsl.length) {
            if (leftPosition == left.length) {
                rsl[leftPosition + rightPosition] = right[rightPosition];
                rightPosition++;
            } else if (rightPosition == right.length) {
                rsl[leftPosition + rightPosition] = left[leftPosition];
                leftPosition++;
            } else if (left[leftPosition] < right[rightPosition]) {
                rsl[leftPosition + rightPosition] = left[leftPosition];
                leftPosition++;
            } else {
                rsl[leftPosition + rightPosition] = right[rightPosition];
                rightPosition++;
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Merge process = new Merge();
        int[] rsl = process.merge(
                new int[] {1, 3, 5},
                new int[] {2, 4}
        );
        System.out.println(Arrays.toString(rsl));
    }

}
