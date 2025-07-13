package org.example.building;

import java.util.ArrayList;
import java.util.Scanner;

public class Shops extends Building {
    public Shops(String buildingName) {
        super(buildingName);
    }

    int getProductPrice(int choice) {
        switch (choice) {
            case 1:
                return 30;
            case 2:
                return 50;
            case 3:
                return 120;
            case 4:
                return 45;
            default:
                return 0;
        }
    }

    String getProductName(int choice) {
        switch (choice) {
            case 1:
                return "Soft Drink";
            case 2:
                return "Pop Corn";
            case 3:
                return "Plush Toy";
            case 4:
                return "Keychain";
            default:
                return "";
        }
    }

    void printReceipt (ArrayList<String> receiptProductNames, ArrayList<Integer> receiptProductPrices, int totalPrice) {
        System.out.println("Receipt:");
        for (int i = 0; i < receiptProductNames.toArray().length; i++) {
            System.out.println("- " + receiptProductNames.get(i) + ": P" + receiptProductPrices.get(i));
        }
        System.out.println("Total Paid: P" + totalPrice);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> receiptProductNames = new ArrayList<>();
        ArrayList<Integer> receiptProductPrices = new ArrayList<>();
        int totalPrice = 0;

        System.out.println("=== Zoo Shop ===");
        System.out.println("Available Products:");
        System.out.println("1. Soft Drink - P30");
        System.out.println("2. Popcorn - P50");
        System.out.println("3. Plush Toy - P120");
        System.out.println("4. Keychain - P45");
        String proceedToCheckout = "no";

        while (proceedToCheckout.equalsIgnoreCase("no")) {
            System.out.print("Enter the number of the item you want to buy: ");
            int numberOfItemToBuy = scanner.nextInt();
            scanner.nextLine();

            if (numberOfItemToBuy < 4 && numberOfItemToBuy > 0) {
                String productName = getProductName(numberOfItemToBuy);
                int productPrice = getProductPrice(numberOfItemToBuy);

                receiptProductNames.add(productName);
                receiptProductPrices.add(productPrice);
                totalPrice += productPrice;

                System.out.println("Selected:");
                System.out.println(productName + " (P" + productPrice + ")\n");
                System.out.println("Total: P" + totalPrice + "\n");

                System.out.print("Proceed to checkout? (yes/no): ");
                proceedToCheckout = scanner.nextLine();
                System.out.println();

                if (proceedToCheckout.equalsIgnoreCase("yes")) {
                    System.out.println("Payment Successful!");
                    printReceipt(receiptProductNames, receiptProductPrices, totalPrice);
                    break;
                }
            } else {
                System.out.println("Invalid item.");
            }
        }


    }
}
