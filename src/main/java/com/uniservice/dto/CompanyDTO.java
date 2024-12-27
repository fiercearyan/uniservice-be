package com.uniservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDTO {
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<VehicleDTO> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleDTO> vehicles) {
        this.vehicles = vehicles;
    }

    public Configurations getConfigurations() {
        return configurations;
    }

    public void setConfigurations(Configurations configurations) {
        this.configurations = configurations;
    }

    private String companyId;
    private String companyName;
    private List<VehicleDTO> vehicles;
    private Configurations configurations;

    @Data
    public static class Configurations {
        private int serviceReminderPeriod;
        private boolean prioritySupport;

        public int getServiceReminderPeriod() {
            return serviceReminderPeriod;
        }

        public void setServiceReminderPeriod(int serviceReminderPeriod) {
            this.serviceReminderPeriod = serviceReminderPeriod;
        }

        public boolean isPrioritySupport() {
            return prioritySupport;
        }

        public void setPrioritySupport(boolean prioritySupport) {
            this.prioritySupport = prioritySupport;
        }
    }
}