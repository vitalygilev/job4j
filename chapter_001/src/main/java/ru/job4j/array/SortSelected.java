package ru.job4j.array;

public class SortSelected {

    public static int[] sort(int[] data) {
        int min;
        int index;
        int temp;
        for (int i = 0; i < data.length; i++) {
            min = MinDiapason.findMin(data, i, data.length);
            index = FindLoop.indexOf(data, min, i, data.length);
            temp = data[i];
            data[i] = data[index];
            data[index] = temp;
        }
        return data;
    }

}
