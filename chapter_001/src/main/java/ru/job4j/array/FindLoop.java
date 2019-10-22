package ru.job4j.array;

public class FindLoop {

    /**
     * Найти элемент массива и вернуть егно индекс
     * если элемента нет в массиве, то возвращаем -1.
     * @param data массив
     * @param el элемент
     * @return Индекс
     */
    public static int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    /**
     *  Найти элемент массива в интервале и вернуть егно индекс
     *  если элемента нет в массиве, то возвращаем -1.
     * @param data массив
     * @param el элемент
     * @param start начало интервала поиска
     * @param finish конец интервала поиска
     * @return Индекс
     */
    public static int indexOf(int[] data, int el, int start, int finish) {
        int rst = -1;
        for (int index = start; index <= finish; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}