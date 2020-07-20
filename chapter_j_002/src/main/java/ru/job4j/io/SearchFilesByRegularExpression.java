package ru.job4j.io;

import java.util.regex.Pattern;

public class SearchFilesByRegularExpression extends SearchFiles {

    private static Pattern pattern;

    public SearchFilesByRegularExpression(String regularExpression) {
        super(p -> pattern.matcher(p.toFile().getName()).matches());
        pattern = Pattern.compile(regularExpression);
    }

}
