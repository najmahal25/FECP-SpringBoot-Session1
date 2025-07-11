package org.example.animals.pachyderms;

import org.example.animals.Animal;
import org.example.building.Building;

public class Pachyderms extends Animal {

    private Building location;

    public Pachyderms(boolean healthy, String name, Building location){
        super(healthy, name);
        this.location = location;
    }

    public void roam(){

    }


}
