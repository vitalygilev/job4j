package ru.job4j;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolLevelOf {

    List<Student> students = new ArrayList<>();

    @Before
    public void initStudentsList() {
        students = Stream.of(new Student("Ivan", "Ivanov", 70),
                new Student("Petr", "Petrov", 100),
                null,
                null
        ).collect(Collectors.toList());
    }

    @Test
    public void whenLevelMoreThan70() {
        List<Student> expect = new ArrayList<>();
        students.add(new Student("Petr", "Petrov", 100));

        assertThat(Student.levelOf(students, 70), is(expect));
    }

}
