package org.example.building.enclosures;

import org.example.animals.felines.Felines;
import org.example.building.Enclosures;

import java.util.ArrayList;

public class FelinesEnclosure extends Enclosures{
    private ArrayList<Felines> listOfFelines = new ArrayList<>();

    public FelinesEnclosure(String buildingName){
        super(buildingName);
    }

    public ArrayList<Felines> getListOfFelines() {
        return listOfFelines;
    }

    public void setListOfFelines(ArrayList<Felines> listOfFelines) {
        this.listOfFelines = listOfFelines;
    }
}
