package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 1000);
        Book generationP = new Book("Generation P", 400);
        Book hammerAndCross = new Book("The Hammer and the Cross", 1300 );
        Book westOfEden = new Book("West of Eden", 1200);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = generationP;
        books[2] = hammerAndCross;
        books[3] = westOfEden;
        for (int index = 0; index < books.length; index ++) {
            System.out.println(books[index].getName() + " " + books[index].getPagesCount());
        }
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;
        for (int index = 0; index < books.length; index ++) {
            if (books[index].getName().equals("Clean code")) {
                System.out.println(books[index].getName() + " " + books[index].getPagesCount() + " index = " + index);
            }
        }
    }

}
