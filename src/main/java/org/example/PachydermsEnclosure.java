package org.example;

import java.util.ArrayList;

public class PachydermsEnclosure extends Enclosures{
    private ArrayList<Pachyderms> listOfPachyderms = new ArrayList<>();

    public PachydermsEnclosure(String buildingName) {
        super(buildingName);
    }

    public ArrayList<Pachyderms> getListOfPachyderms() {
        return listOfPachyderms;
    }

    public void setListOfPachyderms(ArrayList<Pachyderms> listOfPachyderms) {
        this.listOfPachyderms = listOfPachyderms;
    }
}
