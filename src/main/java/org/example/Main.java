package org.example;

import java.util.*;



public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        runAdminModule(zoo);
//      runTicketingModule(); // check first if setup is finished and Zoo is open
    }
    // method to run Administrator module
    private static void runAdminModule(Zoo zoo){
        Scanner s = new Scanner(System.in);
        System.out.println("=== Welcome to the Zoo Admin Console ===\n");
        System.out.println("Please log in.");
        while(true) {
            System.out.print("Enter username: ");
            String username = s.next();
            System.out.print("Enter password: ");
            String password = s.next();

            if (username.equals("admin") && password.equals("adminadmin")) {
                System.out.println("\nLogin Successful. Welcome!");
                break;
            }else{
                System.out.println("\nInvalid credentials. Please try again!");
            }
        }
        boolean runLoop = true;

        while(runLoop){
        System.out.println("====== Zoo Admin Main Menu =====");
        System.out.println("1. Setup Zoo Staff");
        System.out.println("2. Access Handler Module");
        System.out.println("3. Open Zoo to Visitors");
        System.out.println("4. Close Zoo to Visitors");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        int choice = s.nextInt();

        switch(choice){
            case 1:
                setupZooStaff(s, zoo);
                break;
            case 2:
                accessHandlerModule(s, zoo);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                runLoop = false;
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
        System.out.println("=== 🎟️WELCOME TO THE ZOO TICKET SHOP ===");
        System.out.println("\n Here's what you can experience in the zoo:");
        System.out.println("- Visit Animal Enclosures (Elephant, Lion, Owl)");
        System.out.println("- Buy snacks and drinks from our Shops");
        System.out.println("- Listen to science lectures at the Hospital");
        System.out.println("- Buy fun gifts at our Gift Shop");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nWould you like to buy a ticket? (yes/no): ");
        String willBuyTicket = scanner.next();

        if (willBuyTicket.equalsIgnoreCase("yes")) {
            System.out.print("\nEnter your name: ");
            String name = scanner.next();
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            String type = computeTicketType(age); // compute for ticket type based on age
            double price = computeTicketPrice(age); // compute for ticket price based on age
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
        String handlerName = "";
        while(true){
            System.out.println("Enter your name (Handler): ");
            handlerName = scanner.nextLine();

            if(zoo.getListOfPeople().toString().contains(handlerName)){
                break;
            }else{
                    System.out.println(handlerName + " is not a handler.");
                }
        }
        System.out.println("Welcome, Handler " + handlerName + "!\n");
        System.out.println("--- Animal Duty Menu ---");
        System.out.println("Aminals assigned to you:");




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

        ArrayList<People> zooStaffs = zoo.getListOfPeople();
        zooStaffs.add(new Managers(managerName));
        zooStaffs.add(new Veterinarians(veterinarianName));
        zooStaffs.add(new Handlers(pachydermHandlerName));
        zooStaffs.add(new Handlers(felineHandlerName));
        zooStaffs.add(new Handlers(birdHandlerName));
        zooStaffs.add(new Vendors(ticketShopVendorName));
        zooStaffs.add(new Vendors(shopVendorName));

        System.out.println("\nZoo staff setup complete.");





    }

    // helper method which returns ticket type based on age
    private static String computeTicketType(int age) {
        if (age <= 5) {
            return "CHILD";
        } else if (age <= 17) {
            return "STUDENT";
        } else if (age <= 59) {
            return "ADULT";
        } else {
            return "SENIOR";
        }
    }

    // helper method which returns ticket price based on age
    private static double computeTicketPrice(int age) {
        if (age <= 5) {
            return 0.0;
        } else if (age <= 17) {
            return 75.0;
        } else if (age <= 59) {
            return 150.0;
        } else {
            return 50.0;
        }
    }
}