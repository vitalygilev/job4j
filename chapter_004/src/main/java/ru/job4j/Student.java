package ru.job4j;

import java.util.Objects;

public class Student {

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
}
