package ru.job4j;

import org.junit.Test;

import java.lang.reflect.Array;
import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GroupTest {

    private class Pair {
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

    public List<StudentWithUnits> students = new ArrayList<>();

    @Test
    public void initStudentsList() {
        students = Stream.of(new StudentWithUnits("Ivanov Ivan", Set.of("swimming", "climbing", "reading")),
                new StudentWithUnits("Petr Petrov", Set.of("reading", "cycling", "driving")),
                new StudentWithUnits("Cider Ciderov", Set.of("drinking", "sleeping", "climbing"))
        ).collect(Collectors.toList());

        Map<String, Set<String>> expect = new HashMap<>();
        expect.put("driving", Set.of("Petr Petrov"));
        expect.put("swimming", Set.of("Ivanov Ivan"));
        expect.put("drinking", Set.of("Cider Ciderov"));
        expect.put("reading", Set.of("Ivanov Ivan", "Petr Petrov"));
        expect.put("cycling", Set.of("Petr Petrov"));
        expect.put("climbing", Set.of("Cider Ciderov", "Ivanov Ivan"));
        expect.put("sleeping", Set.of("Cider Ciderov"));

        assertThat(Group.sections(students), is(expect));
    }

}
