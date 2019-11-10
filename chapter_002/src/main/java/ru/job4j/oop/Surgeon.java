package ru.job4j.oop;

public class Surgeon extends Doctor {

    public String partOfBody;
    public long nextOperationDate;

    public Surgeon(String name, String surname, String education, long birthday, String hospital, byte seniority,
                   String partOfBody) {
        super(name, surname, education, birthday, hospital, seniority);
        this.partOfBody = partOfBody;
        //this.nextOperationDate = nextOperationDate;
    }

    public String getPartOfBody() {
        return partOfBody;
    }

    /*public long getNextOperationDate() {
        return nextOperationDate;
    }*/
}
