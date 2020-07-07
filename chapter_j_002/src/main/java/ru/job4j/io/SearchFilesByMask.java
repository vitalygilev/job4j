package ru.job4j.io;

public class SearchFilesByMask extends SearchFiles {

    public SearchFilesByMask(String regularExpression) {
        super(p -> p.toFile().getName().matches(regularExpression.replace("?", ".?").replace("*", ".*?")));
    }

}
