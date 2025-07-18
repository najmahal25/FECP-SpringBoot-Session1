package org.example.animals;

public abstract class Animal {
    private boolean healthy;
    private String name;

    protected Animal(boolean healthy, String name){
        this.healthy = healthy;
        this.name = name;
    }

    public void eat(){
        System.out.println(this.name + " loves the food!");
    }

    public void sleep(){

    }

    public void roam(){

    }

    public void makeSound(){

    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
