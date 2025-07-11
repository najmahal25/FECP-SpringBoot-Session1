package org.example;

public class Birds extends Animal{
    private Building location;

    Birds(boolean healthy, String name, Building location){
        super(healthy, name);
        this.location = location;
    }

    public void roam(){

    }
}
