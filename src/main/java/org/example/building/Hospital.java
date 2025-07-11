package org.example.building;

import org.example.animals.Animal;
import java.util.ArrayList;

public class Hospital extends Building {
    private static final Hospital INSTANCE = new Hospital("Zoo Hospital");

    private ArrayList<Animal> listOfInjuredAnimals = new ArrayList<>();

    // private constructor to prevent instantiation
    private Hospital(String buildingName) {
        super(buildingName);
    }

    public static Hospital getInstance() {
        return INSTANCE;
    }

    public ArrayList<Animal> getListOfInjuredAnimals() {
        return listOfInjuredAnimals;
    }

    public void admitAnimal(Animal animal) {
        listOfInjuredAnimals.add(animal);
        System.out.println(animal.getName() + " has been admitted to the hospital.");
    }

    public void dischargeAnimal(Animal animal) {
        listOfInjuredAnimals.remove(animal);
        System.out.println(animal.getName() + " has been discharged from the hospital.");
    }
}
