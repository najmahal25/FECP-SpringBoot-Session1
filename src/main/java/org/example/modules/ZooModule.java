package org.example.modules;

import org.example.Zoo;
import org.example.animals.birds.Birds;
import org.example.animals.felines.Felines;
import org.example.animals.pachyderms.Pachyderms;
import org.example.building.Ticket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ZooModule {
    Zoo zoo;

    public ZooModule (Zoo zoo) {
        this.zoo = zoo;
    }

    boolean verifyTicket () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Visitor Entry ===");
        System.out.print("Enter your ticket code: ");
        String ticketCode = scanner.nextLine();

        for (Ticket ticket : zoo.getTickets()) {
            String currentTicketCode = ticket.getCode();

            if (ticketCode.equals(currentTicketCode)) {
                return true;
            }
        }

        System.out.println("Invalid Ticket Code.");
        return false;
    }

    void visitZooEnclosure() {
        ArrayList<Pachyderms> listOfPachyderms = this.zoo.getListOfAnimals()
                .stream()
                .filter(a -> a instanceof Pachyderms)
                .map(a -> (Pachyderms) a)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Birds> listOfBirds = this.zoo.getListOfAnimals()
                .stream()
                .filter(a -> a instanceof Birds)
                .map(a -> (Birds) a)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Felines> listOfFelines = this.zoo.getListOfAnimals()
                .stream()
                .filter(a -> a instanceof Felines)
                .map(a -> (Felines) a)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Choose enclosure: ");

    }

    void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you do?");
        System.out.println("1. Visit Enclosure");
        System.out.println("2. Visit Shop");
        System.out.println("3. Visit Hospital");
        System.out.println("4. Leave Zoo");
        int choice = 0;

        while (choice != 4) {
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                    System.out.println("You have left the zoo.");
                    break;
                default:
                    System.out.println("Invalid input. Please try again");
                    break;
            }
        }
    }

    public void run() {
        boolean verified = false;

        while (!verified) {
            verified = verifyTicket();
        }

        displayMenu();
    }
}
