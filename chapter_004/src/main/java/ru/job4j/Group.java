package ru.job4j;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {

    public static Map<String, Set<String>> sections(List<StudentWithUnits> students) {
        return students.stream()
                .flatMap(e -> e.getUnits()
                        .stream()
                        .map(t -> t + "|" + e.getName()))
                .collect(Collectors.groupingBy(e -> e.substring(0, e.lastIndexOf("|"))))
                .entrySet()
                .stream()
                .collect(
                        Collectors.toMap(e -> e.getKey(), e -> e.getValue()
                                .stream()
                                .map(e1 -> e1.substring(e1.lastIndexOf("|") + 1))
                                .collect(Collectors.toSet())));
    }

}
