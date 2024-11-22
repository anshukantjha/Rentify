package entities;

public abstract class Property {
    private String address;
    private double rentalPrice;
    private boolean isAvailable;

    public Property(String address, double rentalPrice) {
        this.address = address;
        this.rentalPrice = rentalPrice;
        this.isAvailable = true;
    }

    public String getAddress() {
        return address;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAsRented() {
        this.isAvailable = false;
    }

    public void markAsAvailable() {
        this.isAvailable = true;
    }

    public abstract void displayDetails();
}
