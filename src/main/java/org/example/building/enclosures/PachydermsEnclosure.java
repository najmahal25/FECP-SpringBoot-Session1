package org.example.building.enclosures;

import org.example.animals.Pachyderms;
import org.example.building.Enclosures;

import java.util.ArrayList;

public class PachydermsEnclosure extends Enclosures {
    ArrayList<Pachyderms> listOfPachyderms = new ArrayList<>();

    public PachydermsEnclosure(String buildingName) {
        super(buildingName);
    }
}
