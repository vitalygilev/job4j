package ru.job4j.oop;

public class Doctor extends Profession{

    public String hospital;
    public byte seniority;

    public Doctor(String name, String surname, String education, long birthday, String hospital, byte seniority) {
        super(name, surname, education, birthday);
        this.hospital = hospital;
        this.seniority = seniority;
    }

    public String getHospital() {
        return hospital;
    }

    public byte getSeniority() {
        return seniority;
    }

    public Diagnose heal(Pacient pacient) {
        Diagnose newDiagnose = new Diagnose();
        return newDiagnose;
    }

}
