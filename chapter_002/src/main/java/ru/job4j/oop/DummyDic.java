package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return eng;
    }

    public static void main(String[] args) {
        String word = "may-may";
        DummyDic dic = new DummyDic();
        System.out.println("Неизвестное слово. " + dic.engToRus(word));
    }

}
