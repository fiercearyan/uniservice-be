package com.uniservice.dto;

import lombok.Data;

import lombok.Data;

@Data
public class VehicleDTO {
    private String vehicleId; // For updates, otherwise null for new vehicles
    private String companyId; // Reference to the owning company
    private String type; // e.g., "two-wheeler" or "four-wheeler"
    private String model; // Vehicle model name

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}