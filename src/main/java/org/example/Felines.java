package org.example;

public class Felines extends Animal{
    private Building location;

    Felines(boolean healthy, String name, Building location) {
        super(healthy, name);
        this.location = location;
    }

    public void roam(){

    }
}
