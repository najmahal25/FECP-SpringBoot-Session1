package org.example.utils;

public class TicketHelpers {
    // helper method which returns ticket type based on age
    public static String computeTicketType(int age) {
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
    public static double computeTicketPrice(int age) {
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
