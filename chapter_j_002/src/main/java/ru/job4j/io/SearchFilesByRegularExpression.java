package ru.job4j.io;

public class SearchFilesByRegularExpression extends SearchFiles {

    public SearchFilesByRegularExpression(String regularExpression) {
        super(p -> p.toFile().getName().matches(regularExpression));
    }

}
