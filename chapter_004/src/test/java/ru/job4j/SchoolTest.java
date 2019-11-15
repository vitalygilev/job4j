package ru.job4j;

import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    List<Student> students = new ArrayList<>();

    @Before
    public void initStudentsList() {
        for (int i = 10; i <= 100; i += 10) {
            students.add(new Student(i));
        }
    }

    @Test
    public void whenAGroupSelect() {
        List<Student> expect = Arrays.asList(
                new Student(70),
                new Student(80),
                new Student(90),
                new Student(100)
        );
        assertThat(School.collect(students, student -> {
            int curScore = student.getScore();
            return curScore >= 70 && curScore <=100;
        }), is(expect));
    }

    @Test
    public void whenBGroupSelect() {
        List<Student> expect = Arrays.asList(
                new Student(50),
                new Student(60)
        );
        assertThat(School.collect(students, student -> {
            int curScore = student.getScore();
            return curScore >= 50 && curScore <70;
        }), is(expect));
    }

    @Test
    public void whenCGroupSelect() {
        List<Student> expect = Arrays.asList(
                new Student(10),
                new Student(20),
                new Student(30),
                new Student(40)
        );
        assertThat(School.collect(students, student -> {
            int curScore = student.getScore();
            return curScore >= 0 && curScore <50;
        }), is(expect));
    }
}
