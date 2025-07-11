package org.example;

import java.util.ArrayList;

public class Hospital extends Building {
    ArrayList<Animal> listOfInjuredAnimals;

    public Hospital(String buildingName) {
        super(buildingName);
    }

    public ArrayList<Animal> getListOfInjuredAnimals() {
        return listOfInjuredAnimals;
    }

    public void setListOfInjuredAnimals(ArrayList<Animal> listOfInjuredAnimals) {
        this.listOfInjuredAnimals = listOfInjuredAnimals;
    }
}
