package ru.job4j.array;

public class Defragment {

    /** Метод "сжимает" массив
     * переместить первую не null ячейку
     * Здесь нужен цикл while
     * @param array - исходный массив
     * @return возвращает сжатый массив
     */
    public static String[] compress(String[] array) {
        for (int index = 0; index < array.length; index++) {
            String cell = array[index];
            if (cell == null) {
                int incrementor = 1;
                while (incrementor < array.length - index && array[index + incrementor] == null) {
                    incrementor += 1;
                }
                if (incrementor < array.length - index) {
                    array[index] = array[index + incrementor];
                    array[index + incrementor] = null;
                }
            }
            System.out.print(array[index] + " ");
        }
        return array;
    }

    public static void main(String[] args) {
        String[] input = {"I", null, "wanna", null, "be", null, "compressed"};
        String[] compressed = compress(input);
        System.out.println();
        for (int index = 0; index < compressed.length; index++) {
            System.out.print(compressed[index] + " ");
        }
    }

}
