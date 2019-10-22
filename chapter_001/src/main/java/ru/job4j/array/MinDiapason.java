package ru.job4j.array;

public class MinDiapason {

    /**
     * проверить, что эталон больше, чем элемент. записать в эталон элемент массива.
     * @param array
     * @param start
     * @param finish
     * @return
     */
    public static int findMin(int[] array, int start, int finish) {
        int min = array[start];
        for (int index = start + 1; index < finish; index++) {
            if (array[index] < min) {
                min = array[index];
            }
        }
        return min;
    }

}
