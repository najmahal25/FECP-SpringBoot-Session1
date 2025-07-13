package org.example;

import org.example.animals.Animal;
import org.example.building.Building;
import org.example.building.Ticket;
import org.example.people.People;

import java.util.ArrayList;

public class Zoo {
    private boolean isOpen;
    private ArrayList<People> listOfPeople = new ArrayList<>();
    private ArrayList<Animal> listOfAnimals = new ArrayList<>();
    private ArrayList<Building> listOfBuildings = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public ArrayList<People> getListOfPeople() {
        return listOfPeople;
    }

    public void setListOfPeople(ArrayList<People> listOfPeople) {
        this.listOfPeople = listOfPeople;
    }

    public ArrayList<Animal> getListOfAnimals() {
        return listOfAnimals;
    }

    public void setListOfAnimals(ArrayList<Animal> listOfAnimals) {
        this.listOfAnimals = listOfAnimals;
    }

    public ArrayList<Building> getListOfBuildings() {
        return listOfBuildings;
    }

    public void setListOfBuildings(ArrayList<Building> listOfBuildings) {
        this.listOfBuildings = listOfBuildings;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void openZoo(){
        setOpen(true);
        System.out.println("The zoo is officially opened!");
    }

    public void closeZoo(){
        setOpen(false);
        System.out.println("The zoo is officially closed!");
    }
}
