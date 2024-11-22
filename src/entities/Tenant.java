package entities;

public class Tenant {
    private String name;
    private String contactNumber;

    public Tenant(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void displayTenantInfo() {
        System.out.println("Tenant Name: " + name);
        System.out.println("Contact: " + contactNumber);
    }
}
