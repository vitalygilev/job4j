package ru.job4j;

import org.junit.Test;
import org.junit.Before;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolMapTest {

    List<Student> students = new ArrayList<>();

    @Before
    public void initStudentsList() {
        students.add(new Student("Ivan", "Ivanov", 100));
        students.add(new Student("Petr", "Petrov", 100));
        students.add(new Student("Sidor", "Sidorov", 100));
    }

    @Test
    public void whenListToMap() {
        Map<String, Student> expect = new TreeMap<>();
        expect.put("Ivanov", students.get(0));
        expect.put("Petrov", students.get(1));
        expect.put("Sidorov", students.get(2));

        assertThat(students.stream().collect(
                Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student
                )
        ), is(expect));
    }
}
