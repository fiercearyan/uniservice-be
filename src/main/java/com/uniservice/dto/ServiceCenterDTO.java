package com.uniservice.dto;

import lombok.Data;

@Data
public class ServiceCenterDTO {
    private String name;
    private String location;
    private ContactInfo contactInfo;

    @Data
    public static class ContactInfo {
        private String email;
        private String phone;
    }
}