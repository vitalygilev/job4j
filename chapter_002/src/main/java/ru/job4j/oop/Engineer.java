package ru.job4j.oop;

public class Engineer extends Profession {

    public String university;
    public long specialty;

    public Engineer(String name, String surname, String education, long birthday, String university, long specialty) {
        super(name, surname, education, birthday);
        this.university = university;
        this.specialty = specialty;
    }

    public String getUniversity() {
        return university;
    }

    public long getSpecialty() {
        return specialty;
    }
}
