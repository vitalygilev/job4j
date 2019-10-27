package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {

    public static void main(String[] args) {
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        Scanner input = new Scanner(System.in);
        String ask = input.nextLine();
        int answer = new Random().nextInt(3);
        String textAnswer = "Может быть!";
        switch (answer) {
            case (0):
                textAnswer = "Да!";
                break;
            case (1):
                textAnswer = "Нет!";
                break;
        }
        System.out.println("Вопрос: " + ask + " ответ: " + textAnswer);
    }

}
