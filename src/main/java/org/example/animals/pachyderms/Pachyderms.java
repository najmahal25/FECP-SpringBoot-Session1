package org.example.animals.pachyderms;

import org.example.animals.Animal;
import org.example.building.Building;
import org.example.building.Hospital;

import java.time.LocalDateTime;

public class Pachyderms extends Animal {
    final static Hospital hospital = Hospital.getInstance();
    private Building location;

    public Pachyderms(boolean healthy, String name, Building location){
        super(healthy, name);
        this.location = location;
    }

    public void roam(){
        System.out.println(this.getName() + " is exercising!");
    }


    public Building getLocation() {
        return location;
    }

    public void setLocation(Building location) {
        this.location = location;
    }

    public void examineToVet() {

        System.out.println("Sending to hospital...");
        hospital.admitAnimal(this);
        this.location = hospital;
        System.out.println(this.getName() + " admitted at " + LocalDateTime.now());

    }
}
