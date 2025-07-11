package org.example;

import java.util.ArrayList;

public class BirdsEnclosure extends Enclosures{

    private ArrayList<Birds> listOfBirds = new ArrayList<>();

    public BirdsEnclosure(String buildingName) {
        super(buildingName);
    }

    public ArrayList<Birds> getListOfBirds() {
        return listOfBirds;
    }

    public void setListOfBirds(ArrayList<Birds> listOfBirds) {
        this.listOfBirds = listOfBirds;
    }
}
