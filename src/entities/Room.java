package entities;

public class Room extends Property {
    private boolean sharedBathroom;

    public Room(String address, double rentalPrice, boolean sharedBathroom) {
        super(address, rentalPrice);
        this.sharedBathroom = sharedBathroom;
    }

    public boolean hasSharedBathroom() {
        return sharedBathroom;
    }

    @Override
    public void displayDetails() {
        System.out.println("Room Address: " + getAddress());
        System.out.println("Price: $" + getRentalPrice());
        System.out.println("Shared Bathroom: " + (sharedBathroom ? "Yes" : "No"));
        System.out.println("Available: " + (isAvailable() ? "Yes" : "No"));
    }
}
