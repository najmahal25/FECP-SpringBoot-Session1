package org.example;

import org.example.animals.birds.Birds;
import org.example.animals.felines.Felines;
import org.example.animals.felines.Lion;
import org.example.animals.pachyderms.Pachyderms;
import org.example.people.*;
import org.example.animals.*;
import org.example.building.*;
import org.example.utils.TicketHelpers;
import org.example.building.enclosures.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        // for demonstration purposes; adding Animals to enclosure
        FelinesEnclosure felineEnclosure = new FelinesEnclosure("Feline Enclosure");
        PachydermsEnclosure pachydermsEnclosure = new PachydermsEnclosure("Pachyderms Enclosure");
        BirdsEnclosure birdsEnclosure = new BirdsEnclosure("Birds Enclosure");

        ArrayList<Building> newListOfBuildings = zoo.getListOfBuildings();
        newListOfBuildings.add(felineEnclosure);
        newListOfBuildings.add(pachydermsEnclosure);
        newListOfBuildings.add(birdsEnclosure);
        zoo.setListOfBuildings(newListOfBuildings);

        // for demonstration purposes; adding Animals to enclosure
        Lion simba = new Lion(true, "Simba,", felineEnclosure);
        Lion mufasa = new Lion(true, "Mufasa,", felineEnclosure);

        ArrayList<Animal> newListOfAnimals = zoo.getListOfAnimals();
        newListOfAnimals.add(simba);
        newListOfAnimals.add(mufasa);
        zoo.setListOfAnimals(newListOfAnimals);

        ArrayList<Felines> newFelineEnclosure = felineEnclosure.getListOfFelines();
        newFelineEnclosure.add(simba);
        newFelineEnclosure.add(mufasa);
        felineEnclosure.setListOfFelines(newFelineEnclosure);

        runAdminModule(zoo);
//        runTicketingModule(); // check first if setup is finished and Zoo is open
    }

    // method to run Administrator module
    private static void runAdminModule(Zoo zoo) {
        Scanner s = new Scanner(System.in);
        System.out.println("=== Welcome to the Zoo Admin Console ===\n");
        System.out.println("Please log in.");

        while (true) {
            System.out.print("Enter username: ");
            String username = s.next();

            System.out.print("Enter password: ");
            String password = s.next();

            if (username.equals("admin") && password.equals("adminadmin")) {
                System.out.println("\nLogin Successful. Welcome!");
                break;
            } else {
                System.out.println("\nInvalid credentials. Please try again!");
            }
        }

        boolean runLoop = true;
        int choice = 0;

        while (choice != 5) {
            System.out.println("====== Zoo Admin Main Menu =====");
            System.out.println("1. Setup Zoo Staff");
            System.out.println("2. Access Handler Module");
            System.out.println("3. Open Zoo to Visitors");
            System.out.println("4. Close Zoo to Visitors");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = s.nextInt();

            switch(choice){
                case 1:
                    setupZooStaff(s, zoo);
                    break;
                case 2:
                    accessHandlerModule(s, zoo);
                    break;
                case 3:
                case 4:
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // method to run ticketing module
    private static void runTicketingModule() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== 🎟️WELCOME TO THE ZOO TICKET SHOP ===");
        System.out.println("\n Here's what you can experience in the zoo:");
        System.out.println("- Visit Animal Enclosures (Elephant, Lion, Owl)");
        System.out.println("- Buy snacks and drinks from our Shops");
        System.out.println("- Listen to science lectures at the Hospital");
        System.out.println("- Buy fun gifts at our Gift Shop");
        System.out.print("\nWould you like to buy a ticket? (yes/no): ");
        String willBuyTicket = scanner.next();

        if (willBuyTicket.equalsIgnoreCase("yes")) {
            System.out.print("\nEnter your name: ");
            String name = scanner.next();

            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            String type = TicketHelpers.computeTicketType(age); // compute for ticket type based on age
            double price = TicketHelpers.computeTicketPrice(age); // compute for ticket price based on age

            System.out.println("\nYou qualify for a " + type + " ticket.");
            System.out.printf("Ticket Price: ₱%.2f", price);

            System.out.print("\n\nProceed with purchase? (yes/no): ");
            String willProceedWithPurchase = scanner.next();

            if (willProceedWithPurchase.equalsIgnoreCase("yes")) {
                // create ticket
                Ticket ticket = new Ticket(
                        name,
                        age,
                        type,
                        price,
                        "ZOO-" + (1000 + (int)(Math.random() * 9000) + 1000) // randomly generate ticket code
                );

                System.out.println("\nTicket purchased!");
                System.out.println("Your ticket code is: " + ticket.getCode());
                System.out.println("\n[Ticket added to system]");
            }
        }
    }


    // helper method for accessing handler module
    private static void accessHandlerModule(Scanner scanner, Zoo zoo){
        List<Handlers> handlers = zoo.getListOfPeople().stream()
                .filter(handler -> handler instanceof Handlers)
                .map(handler -> (Handlers) handler)
                .toList();
        System.out.println(handlers.toString());
        if(handlers.isEmpty()){
            System.out.println("No Handlers yet.");
        }else{
            scanner.nextLine(); // removes
            while(true){
                System.out.print("Enter your name (Handler): ");

                String handlerName = scanner.nextLine();



                if(handlers.toString().contains(handlerName)){
                    Handlers handler = handlers.stream()
                            .filter(person -> person.getName().equals(handlerName))
                            .findFirst()
                            .orElse(null);
                    if (handler == null) {
                        System.out.println(handlerName + " is not a handler.");
                    }else {
                        System.out.println("Welcome, Handler " + handler.getName() + "!\n");
                        System.out.println("--- Animal Duty Menu ---");
                        System.out.println("Animals assigned to you:");
                        Enclosures location = handler.getLocation();
                        int animalSelected;

                        switch (location) {
                            case PachydermsEnclosure pachydermsEnclosure:
                                ArrayList<Pachyderms> pachydermsList = pachydermsEnclosure.getListOfPachyderms();
                                for (int i = 0; i < pachydermsList.size(); i++) {
                                    System.out.printf("%d. %s\n", i, pachydermsList.get(i).getName());
                                }
                                while(true){
                                System.out.println("Choose Animal to interact with (0 to exit): ");
                                animalSelected = scanner.nextInt();

                                    if(animalSelected > pachydermsList.size() || animalSelected < 0){
                                        System.out.println("Invalid choice. Please try again.");

                                    } else if (animalSelected == 0) {
                                        break;
                                    } else {
                                        Pachyderms pachydermSelected = pachydermsList.get(animalSelected);
                                        System.out.println("Choose Action");
                                        System.out.println("1. Feed " + pachydermSelected.getName());
                                        System.out.println("2. Exercise + " + pachydermSelected.getName());
                                        System.out.println("3. Examine Mufasa to Vet");
                                        int choice = scanner.nextInt();

                                        switch (choice) {
                                            case 1:
                                                pachydermSelected.eat();
                                                break;
                                            case 2:
                                                pachydermSelected.roam();
                                                break;
                                            case 3:
//                                                pachydermSelected.ex();
                                                break;
                                            default:
                                                System.out.println("invalid input.");
                                                break;
                                        }
                                    }
                                }


                                break;
                            case FelinesEnclosure felinesEnclosure:
                                ArrayList<Felines> felinesList = felinesEnclosure.getListOfFelines();
                                for (int i = 0; i < felinesList.size(); i++) {
                                    System.out.printf("%d. %s", i, felinesList.get(i).getName());
                                }
                                System.out.println("Choose Animal to interact with (0 to exit): ");
                                animalSelected = scanner.nextInt();
                                break;
                            case BirdsEnclosure birdsEnclosure:
                                ArrayList<Birds> birdsList = birdsEnclosure.getListOfBirds();
                                for (int i = 0; i < birdsList.size(); i++) {
                                    System.out.printf("%d. %s", i, birdsList.get(i).getName());
                                }
                                System.out.println("Choose Animal to interact with (0 to exit): ");
                                animalSelected = scanner.nextInt();
                                break;
                            case null:
                            default:
                                System.out.println("Handler not in Enclosure.");
                                break;
                        }



                    }

                }else{
                    System.out.println(handlerName + " is not a handler.");
                }
            }
        }
    }

    // helper method for setting up Zoo Staff
    private static void setupZooStaff(Scanner scanner, Zoo zoo) {
        System.out.println("--- Zoo Setup ---");

        System.out.print("\nEnter your name, Manager: ");
        scanner.nextLine(); //consumes leftover newline character
        String managerName = scanner.nextLine();

        System.out.print("\nEnter Veteinarian's name: ");
        String veterinarianName = scanner.nextLine();

        System.out.print("\nEnter Handler for Pachyderm Enclosure: ");
        String pachydermHandlerName = scanner.nextLine();

        System.out.print("\nEnter Handler for Feline Enclosure: ");
        String felineHandlerName = scanner.nextLine();

        System.out.print("\nEnter Handler for Bird Enclosure: ");
        String birdHandlerName = scanner.nextLine();

        System.out.print("\nEnter Vendor for Ticket Shop: ");
        String ticketShopVendorName = scanner.nextLine();

        System.out.print("\nEnter Vendor for Shop: ");
        String shopVendorName = scanner.nextLine();

        ArrayList<People> newZooStaff = zoo.getListOfPeople();
        newZooStaff.add(new Managers(managerName));
        newZooStaff.add(new Veterinarians(veterinarianName));
        newZooStaff.add(new Handlers(pachydermHandlerName, (Enclosures) getBuildingByClass(zoo.getListOfBuildings(), PachydermsEnclosure.class)));
        newZooStaff.add(new Handlers(felineHandlerName, (Enclosures) getBuildingByClass(zoo.getListOfBuildings(), FelinesEnclosure.class)));
        newZooStaff.add(new Handlers(birdHandlerName, (Enclosures) getBuildingByClass(zoo.getListOfBuildings(), BirdsEnclosure.class)));
        newZooStaff.add(new Vendors(ticketShopVendorName));
        newZooStaff.add(new Vendors(shopVendorName));
        zoo.setListOfPeople(newZooStaff);

        System.out.println("\nZoo staff setup complete.");

    }
    // helper method for getting differing enclosures
    public static Building getBuildingByClass(ArrayList<Building> buildings, Class<?> clazz) {
        for (Building building : buildings) {
            if (clazz.isInstance(building)) {
                return building;
            }
        }
        return null; // Or throw an exception if the building is not found
    }
}