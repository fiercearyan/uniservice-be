package com.uniservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "companies")
public class Company {

    @Id
    private String id; // Company ID
    private String companyName;
    private Configurations configurations;

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Configurations getConfigurations() {
        return configurations;
    }

    public void setConfigurations(Configurations configurations) {
        this.configurations = configurations;
    }

    // Nested Class
    public static class Configurations {
        private int serviceReminderPeriod;
        private boolean prioritySupport;

        // Getters and Setters
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