package org.example;

import java.util.ArrayList;

public class Zoo {
    private boolean isOpen;
    private ArrayList<People> listOfPeople;
    private ArrayList<Animal> listOfAnimals;
    private ArrayList<Building> listOfBuildings;

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public ArrayList<People> getListOfPeople() {
        return listOfPeople;
    }

    public void setListOfPeople(ArrayList<People> listOfPeople) {
        this.listOfPeople = listOfPeople;
    }

    public ArrayList<Animal> getListOfAnimals() {
        return listOfAnimals;
    }

    public void setListOfAnimals(ArrayList<Animal> listOfAnimals) {
        this.listOfAnimals = listOfAnimals;
    }

    public ArrayList<Building> getListOfBuildings() {
        return listOfBuildings;
    }

    public void setListOfBuildings(ArrayList<Building> listOfBuildings) {
        this.listOfBuildings = listOfBuildings;
    }
}
