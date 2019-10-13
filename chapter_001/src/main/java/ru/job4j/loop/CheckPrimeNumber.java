package ru.job4j.loop;

public class CheckPrimeNumber {

    public boolean check(int finish) {
        boolean prime = false;
        for (int i = 2; i < finish; i++) {
            prime = (finish % i == 0);
            if (prime) {
                break;
            }
        }
        return !prime;
    }
}
