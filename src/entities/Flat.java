package entities;

public class Flat extends Property {
    private int numberOfRooms;
    private boolean furnished;

    public Flat(String address, double rentalPrice, int numberOfRooms, boolean furnished) {
        super(address, rentalPrice);
        this.numberOfRooms = numberOfRooms;
        this.furnished = furnished;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public boolean isFurnished() {
        return furnished;
    }

    @Override
    public void displayDetails() {
        System.out.println("Flat Address: " + getAddress());
        System.out.println("Price: $" + getRentalPrice());
        System.out.println("Rooms: " + numberOfRooms);
        System.out.println("Furnished: " + (furnished ? "Yes" : "No"));
        System.out.println("Available: " + (isAvailable() ? "Yes" : "No"));
    }
}
