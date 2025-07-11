package org.example;

import java.util.ArrayList;

public class FelinesEnclosure extends Enclosures{
    private ArrayList<Felines> listOfFelines = new ArrayList<>();

    FelinesEnclosure(String buildingName){
        super(buildingName);
    }

    public ArrayList<Felines> getListOfFelines() {
        return listOfFelines;
    }

    public void setListOfFelines(ArrayList<Felines> listOfFelines) {
        this.listOfFelines = listOfFelines;
    }
}
