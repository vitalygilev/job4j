package ru.job4j.oop;

public class Dentist extends Doctor {

    public String currentPatient;
    public long visitDate;

    public Dentist(String name, String surname, String education, long birthday, String hospital, byte seniority,
                   String currentPatient) {
        super(name, surname, education, birthday, hospital, seniority);
        this.currentPatient = currentPatient;
        //this.visitDate = visitDate;
    }

    public String getCurrentPatient() {
        return currentPatient;
    }

    /*public long getVisitDate() {
        return visitDate;
    }*/
}
