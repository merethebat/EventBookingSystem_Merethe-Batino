// Author: Merethe Batino
// Project: Event Booking System

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            EventBookingSystem bookingSystem = new EventBookingSystem();
            boolean running = true;
            
            while (running) {
                System.out.println("\nEvent Booking System");
                System.out.println("1. Create event");
                System.out.println("2. View events");
                System.out.println("3. Register attendee");
                System.out.println("4. Cancel registration");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                
                String choice = input.nextLine();
                
                switch (choice) {
                    case "1" -> {
                        System.out.print("Event name: ");
                        String name = input.nextLine();
                        System.out.print("Event capacity: ");
                        try {
                            int capacity = Integer.parseInt(input.nextLine());
                            if (bookingSystem.createEvent(name, capacity)) {
                                System.out.println("Event created.");
                            } else {
                                System.out.println("Could not create event. Check the name, capacity, or duplicates.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a whole number for capacity.");
                        }
                    }
                    case "2" -> {
                        List<Event> events = bookingSystem.getEvents();
                        if (events.isEmpty()) {
                            System.out.println("There are no events yet.");
                        } else {
                            for (Event event : events) {
                                System.out.println(event);
                            }
                        }
                    }
                    case "3" -> {
                        System.out.print("Event name: ");
                        String eventName = input.nextLine();
                        System.out.print("Attendee name: ");
                        String attendee = input.nextLine();
                        if (bookingSystem.registerAttendee(eventName, attendee)) {
                            System.out.println("Registration completed.");
                        } else {
                            System.out.println("Registration failed. Check the event, name, or capacity.");
                        }
                    }
                    case "4" -> {
                        System.out.print("Event name: ");
                        String eventName = input.nextLine();
                        System.out.print("Attendee name: ");
                        String attendee = input.nextLine();
                        if (bookingSystem.cancelRegistration(eventName, attendee)) {
                            System.out.println("Registration cancelled.");
                        } else {
                            System.out.println("Could not find that registration.");
                        }
                    }
                    case "5" -> running = false;
                    default -> System.out.println("Please choose a number from 1 to 5.");
                }
            }
        }
        System.out.println("Goodbye!");
    }
}
