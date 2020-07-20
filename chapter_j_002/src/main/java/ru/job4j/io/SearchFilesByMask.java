package ru.job4j.io;

import java.util.regex.Pattern;

public class SearchFilesByMask extends SearchFiles {

    private static Pattern pattern;

    public SearchFilesByMask(String regularExpression) {
        super(p -> pattern.matcher(p.toFile().getName()).matches());
        final String curRegularExpression = regularExpression.replace("?", ".?").replace("*", ".*?");
        pattern = Pattern.compile(curRegularExpression);
    }

}
