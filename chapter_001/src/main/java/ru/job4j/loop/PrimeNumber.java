package ru.job4j.loop;

public class PrimeNumber {
    public int calc(int finish) {

        int count = 0;
        boolean prime;

        for (int current = 2; current <= finish; current++) {
            prime = false;
            for (int i = 2; i < current; i++) {
                prime = (current % i == 0);
                if (prime) {
                    break;
                }
            }
            if (!prime) {
                count++;
            }
        }
        return count;
    }
}
