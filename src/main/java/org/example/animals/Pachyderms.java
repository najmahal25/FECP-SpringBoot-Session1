package org.example.animals;

import org.example.building.Building;

public class Pachyderms extends Animal {

    private Building location;

    Pachyderms(boolean healthy, String name, Building location){
        super(healthy, name);
        this.location = location;
    }

    public void roam(){

    }


}
