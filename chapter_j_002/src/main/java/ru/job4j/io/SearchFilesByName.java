package ru.job4j.io;

public class SearchFilesByName extends SearchFiles {

    public SearchFilesByName(String regularExpression) {
        super(p -> p.toFile().getName().equals(regularExpression));
    }

}
