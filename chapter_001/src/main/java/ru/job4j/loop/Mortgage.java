package ru.job4j.loop;

public class Mortgage {

    public int year(int amount, int salary, double percent) {
        int year = 0;
        double balance = amount;
        do {
            year++;
            balance = balance + balance * percent / 100 - salary;
            if (balance >= amount){
                year = -1;
                break; //Вы в долговой яме!
            }
        }while (balance > 0);

        return year;
    }

}
