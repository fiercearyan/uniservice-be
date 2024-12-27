package com.uniservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "service_centers")
public class ServiceCenter {

    @Id
    private String id;
    private String companyId;
    private String name;
    private String location;
    private ContactInfo contactInfo;

    // Getters and Setters...

    public static class ContactInfo {
        private String email;
        private String phone;

        // Getters and Setters...
    }
}