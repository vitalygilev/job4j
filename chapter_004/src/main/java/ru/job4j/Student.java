package ru.job4j;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {

    String firstName;
    String surname;

    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(int score) {
        this.score = score;
    }

    public Student(String firstName, String surname, int score) {
        this.firstName = firstName;
        this.surname = surname;
        this.score = score;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Student{"
                + "firstName='" + firstName + '\''
                + ", surname='" + surname + '\''
                + ", score=" + score
                + '}';
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }

    static List<Student> levelOf(List<Student> students, int bound) {
        return students
                .stream()
                .flatMap(Stream::ofNullable)
                .sorted()
                .takeWhile(curStudent -> curStudent.getScore() > bound)
                .collect(Collectors.toList());
    }

}
