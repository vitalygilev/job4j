package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        byte currentMatches = 11;
        int currentPlayer = 2;
        System.out.println("Игра Matches. На столе лежат 11 спичек. Два игрока по очереди берут от 1 до 3 спичек. Выигрывает тот, кто забрал последние спички.");
        String interval;
        int select;
        while (currentMatches > 0) {
            currentPlayer = (currentPlayer % 2) + 1;
            if (currentMatches == 1) {
                interval = "1";
            } else if (currentMatches < 3) {
                interval = "1-" + currentMatches;
            } else {
                interval = "1-3";
            }
            do {
                System.out.print("Осталось " + currentMatches + " спичек. Игрок " + currentPlayer + " тяните спички (" + interval + "): ");
                Scanner input = new Scanner(System.in);
                select = Integer.valueOf(input.nextLine());
            } while (select < 1 || select > 3 || select > currentMatches);
            currentMatches -= select;
        }
        System.out.println("Победил игрок " + currentPlayer + "!");
    }

}
