package ru.job4j.loop;

public class Counter {

    public static int add(int start, int finish) {
        int sum = 0;
        for (int index = start; index <= finish; index++) {
            if (index % 2 != 0) continue;
            sum = sum + index;
        }
        return sum;
    }
}
