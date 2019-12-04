package ru.job4j;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Group {

    private static class Pair {
        private String student;
        private String section;

        public String getStudent() {
            return student;
        }

        public String getSection() {
            return section;
        }

        public Pair(String student, String section) {
            this.student = student;
            this.section = section;
        }
    }
    public static Map<String, Set<String>> sections(List<StudentWithUnits> students) {

        return students.stream()
                .flatMap(e -> e.getUnits()
                        .stream()
                        .map(t -> new Pair(e.getName(), t)))
                .collect(Collectors.groupingBy(Pair::getSection))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, t -> t.getValue()
                        .stream()
                        .map(Pair::getStudent)
                        .collect(Collectors.toSet())));

        /*return students.stream()
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
                                .collect(Collectors.toSet())));*/
    }

}
