package org.example.people;

import org.example.building.Enclosures;

public class Handlers extends People{
    private Enclosures location;

    public Handlers(String handlerName, Enclosures location){
        super(handlerName);
        this.location = location;

    }
    public void feed(){

    }

    public String toString(){
        return getName();
    }

    public void exercise(){

    }

    public void examine(){

    }

    @Override
    public Enclosures getLocation() {
        return location;
    }

    public void setLocation(Enclosures location) {
        this.location = location;
    }
}
