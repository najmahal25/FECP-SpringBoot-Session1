package org.example;

import java.util.ArrayList;

public abstract class Enclosures extends Building {
    ArrayList<Animal> listOfAnimals = new ArrayList<>();
    public Enclosures(String buildingName) {
        super(buildingName);
    }
}
