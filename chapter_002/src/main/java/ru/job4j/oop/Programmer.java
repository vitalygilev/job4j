package ru.job4j.oop;

public class Programmer extends Engineer {

    public String currentProject;
    public long endOfProject;

    public Programmer(String name, String surname, String education, long birthday, String university, long specialty,
                      String currentProject) {
        super(name, surname, education, birthday, university, specialty);
        this.currentProject = currentProject;
        //this.endOfProject = endOfProject;
    }

    public String getCurrentProject() {
        return currentProject;
    }

    /*public long getEndOfProject() {
        return endOfProject;
    }*/

    public ImplementationProject initiateProject(AccSystem accSystem) {
        ImplementationProject newProject = new ImplementationProject();
        return newProject;
    }

}

