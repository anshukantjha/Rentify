package services;

import entities.Property;

import java.util.ArrayList;
import java.util.List;

public class PropertyService {
    private List<Property> properties = new ArrayList<>();

    public void addProperty(Property property) {
        properties.add(property);
    }

    public List<Property> getAvailableProperties() {
        List<Property> availableProperties = new ArrayList<>();
        for (Property property : properties) {
            if (property.isAvailable()) {
                availableProperties.add(property);
            }
        }
        return availableProperties;
    }

    public void displayAllProperties() {
        for (Property property : properties) {
            property.displayDetails();
            System.out.println("-------------------");
        }
    }
}
