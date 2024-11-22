
import entities.*;
import services.PropertyService;
import services.TenantService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PropertyService propertyService = new PropertyService();
    private static final TenantService tenantService = new TenantService();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> addProperty();
                case 2 -> displayAvailableProperties();
                case 3 -> addTenant();
                case 4 -> assignTenantToProperty();
                case 5 -> viewAllProperties();
                case 6 -> viewAllTenants();
                case 0 -> {
                    System.out.println("Thank you for using Rentify!");
                    exit = true;
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n--- Rentify Menu ---");
        System.out.println("1. Add Property");
        System.out.println("2. View Available Properties");
        System.out.println("3. Add Tenant");
        System.out.println("4. Assign Tenant to Property");
        System.out.println("5. View All Properties");
        System.out.println("6. View All Tenants");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid choice
        }
    }

    private static void addProperty() {
        System.out.println("\n--- Add Property ---");
        System.out.println("1. Add Room");
        System.out.println("2. Add Flat");
        System.out.print("Enter your choice: ");
        int typeChoice = getUserChoice();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Rental Price: ");
        double price = Double.parseDouble(scanner.nextLine());

        switch (typeChoice) {
            case 1 -> {
                System.out.print("Shared Bathroom (true/false): ");
                boolean sharedBathroom = Boolean.parseBoolean(scanner.nextLine());
                propertyService.addProperty(new Room(address, price, sharedBathroom));
                System.out.println("Room added successfully!");
            }
            case 2 -> {
                System.out.print("Number of Rooms: ");
                int rooms = Integer.parseInt(scanner.nextLine());
                System.out.print("Furnished (true/false): ");
                boolean furnished = Boolean.parseBoolean(scanner.nextLine());
                propertyService.addProperty(new Flat(address, price, rooms, furnished));
                System.out.println("Flat added successfully!");
            }
            default -> System.out.println("Invalid choice! Returning to main menu.");
        }
    }

    private static void displayAvailableProperties() {
        System.out.println("\n--- Available Properties ---");
        List<Property> availableProperties = propertyService.getAvailableProperties();
        if (availableProperties.isEmpty()) {
            System.out.println("No properties available!");
        } else {
            for (Property property : availableProperties) {
                property.displayDetails();
                System.out.println("-------------------");
            }
        }
    }

    private static void addTenant() {
        System.out.println("\n--- Add Tenant ---");
        System.out.print("Enter Tenant Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();
        tenantService.addTenant(new Tenant(name, contactNumber));
        System.out.println("Tenant added successfully!");
    }

    private static void assignTenantToProperty() {
        System.out.println("\n--- Assign Tenant to Property ---");
        List<Property> availableProperties = propertyService.getAvailableProperties();
        if (availableProperties.isEmpty()) {
            System.out.println("No properties available for assignment!");
            return;
        }

        System.out.println("Available Properties:");
        for (int i = 0; i < availableProperties.size(); i++) {
            System.out.println((i + 1) + ". " + availableProperties.get(i).getAddress());
        }
        System.out.print("Select a property (enter number): ");
        int propertyChoice = Integer.parseInt(scanner.nextLine()) - 1;

        if (propertyChoice < 0 || propertyChoice >= availableProperties.size()) {
            System.out.println("Invalid property selection!");
            return;
        }

        System.out.println("Available Tenants:");
        List<Tenant> tenants = tenantService.getTenants();
        if (tenants.isEmpty()) {
            System.out.println("No tenants available for assignment!");
            return;
        }

        for (int i = 0; i < tenants.size(); i++) {
            System.out.println((i + 1) + ". " + tenants.get(i).getName());
        }
        System.out.print("Select a tenant (enter number): ");
        int tenantChoice = Integer.parseInt(scanner.nextLine()) - 1;

        if (tenantChoice < 0 || tenantChoice >= tenants.size()) {
            System.out.println("Invalid tenant selection!");
            return;
        }

        availableProperties.get(propertyChoice).markAsRented();
        System.out.println("Tenant assigned to property successfully!");
    }

    private static void viewAllProperties() {
        System.out.println("\n--- All Properties ---");
        propertyService.displayAllProperties();
    }

    private static void viewAllTenants() {
        System.out.println("\n--- All Tenants ---");
        tenantService.displayAllTenants();
    }
}
