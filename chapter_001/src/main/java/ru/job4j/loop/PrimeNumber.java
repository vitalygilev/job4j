package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {
        int count = 0;
        CheckPrimeNumber checker = new CheckPrimeNumber();
        boolean prime;
        for (int current = 2; current <= finish; current++) {
            if (checker.check(current)) {
                count++;
            }
        }
        return count;
    }
}
