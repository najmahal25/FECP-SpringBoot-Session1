package org.example.people;

import org.example.building.Building;

public abstract class People {
    private String name;
    private Building location;

    People(String name){
        this.name = name;
    }


    public void goTo(Building destination){
        this.location = destination;
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
