package ru.job4j.loop;

public class Mortgage {

    /**
     * Определение количества лет, необходимых для выплаты ипотеки.
     * Если с каждым годом долг только растет - Вы в долговой яме - возвращаем -1!
     * @param amount
     * @param salary
     * @param percent
     * @return
     */
    public int year(int amount, int salary, double percent) {
        int year = 0;
        double balance = amount;
        do {
            year++;
            balance = balance + balance * percent / 100 - salary;
            if (balance >= amount) {
                year = -1;
                break;
            }
        } while (balance > 0);

        return year;
    }

}
