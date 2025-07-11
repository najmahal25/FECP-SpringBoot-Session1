package org.example.building;

import java.util.ArrayList;

public abstract class Enclosures extends Building {
    ArrayList<Animal> listOfAnimals = new ArrayList<>();
    public Enclosures(String buildingName) {
        super(buildingName);
    }

    public static class Hospital extends Building {
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

    public static class Shops extends Building{

        public Shops(String buildingName) {
            super(buildingName);
        }
    }
}
