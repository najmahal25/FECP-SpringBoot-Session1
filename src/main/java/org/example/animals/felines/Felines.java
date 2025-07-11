package org.example.animals.felines;

import org.example.animals.Animal;
import org.example.building.Building;
import org.example.building.Hospital;

import java.time.LocalDateTime;

public class Felines extends Animal {
    private Building location;
    final static Hospital hospital = Hospital.getInstance();

    public Felines(boolean healthy, String name, Building location) {
        super(healthy, name);
        this.location = location;
    }

    public void roam(){
        System.out.println(this.getName() + " is exercising!");
    }
    public void examineToVet() {
        System.out.println("Sending to hospital...");
        hospital.admitAnimal(this);
        this.location = hospital;
        System.out.println(this.getName() + " admitted at " + LocalDateTime.now());

    }
}
