package ru.job4j.condition;

public class SqMax {

    public static int max(int first, int second) {
        int result = first;
        if (first < second) {
            result = second;
        }
        return result;
    }

    public static int max(int first, int second, int third) {
        return max(first, max(second, third));
    }

    public static int max(int first, int second, int third, int forth) {
        return max(max(first, second), max(third, forth));
    }

}
