package org.example.building;

import org.example.animals.Animal;

import java.util.ArrayList;

public class Hospital extends Building {
    ArrayList<Animal> listOfInjuredAnimals;

    public Hospital(String buildingName) {
        super(buildingName);

    }
}
