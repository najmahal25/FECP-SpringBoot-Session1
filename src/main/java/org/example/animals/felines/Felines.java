package org.example.animals.felines;

import org.example.animals.Animal;
import org.example.building.Building;

public class Felines extends Animal {
    private Building location;

    public Felines(boolean healthy, String name, Building location) {
        super(healthy, name);
        this.location = location;
    }

    public void roam(){

    }
}
