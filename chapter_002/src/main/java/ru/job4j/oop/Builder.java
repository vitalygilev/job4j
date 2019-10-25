package ru.job4j.oop;

public class Builder extends Engineer {

    public String currentObject;
    public long endOfBuilding;

    public Builder(String name, String surname, String education, long birthday, String university, long specialty,
                   String currentObject, long endOfBuilding) {
        super(name, surname, education, birthday, university, specialty);
        this.currentObject = currentObject;
        this.endOfBuilding = endOfBuilding;
    }

    public String getCurrentObject() {
        return currentObject;
    }

    public long getEndOfBuilding() {
        return endOfBuilding;
    }

    public BuildingProject makeProject(Building building) {
        BuildingProject newProject = new BuildingProject();
        return newProject;
    }
}
