package org.example;

public abstract class People {
    private String name;
    private Building location;

    public void goTo(Building destination){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Building getLocation() {
        return location;
    }

    public void setLocation(Building location) {
        this.location = location;
    }
}
