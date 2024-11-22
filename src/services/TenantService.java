package services;

import entities.Tenant;

import java.util.ArrayList;
import java.util.List;

public class TenantService {
    private List<Tenant> tenants = new ArrayList<>();

    public void addTenant(Tenant tenant) {
        tenants.add(tenant);
    }

    public List<Tenant> getTenants(){
        return tenants;
    }

    public void displayAllTenants() {
        for (Tenant tenant : tenants) {
            tenant.displayTenantInfo();
            System.out.println("-------------------");
        }
    }
}
