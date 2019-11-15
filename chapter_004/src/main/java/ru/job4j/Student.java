package ru.job4j;

import java.util.Objects;

public class Student {

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return score == student.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", score=" + score +
                '}';
    }
}
