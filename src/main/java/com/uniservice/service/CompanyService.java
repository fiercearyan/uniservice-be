package com.uniservice.service;

import com.uniservice.dto.CompanyDTO;
import com.uniservice.dto.VehicleDTO;
import com.uniservice.entity.Company;
import com.uniservice.entity.Vehicle;
import com.uniservice.repository.CompanyRepository;
import com.uniservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public void onboardCompany(CompanyDTO companyDTO) {
        // Create and save the company
        Company company = new Company();
        company.setCompanyName(companyDTO.getCompanyName());
        if (companyDTO.getConfigurations() != null) {
            Company.Configurations configurations = new Company.Configurations();
            configurations.setServiceReminderPeriod(companyDTO.getConfigurations().getServiceReminderPeriod());
            configurations.setPrioritySupport(companyDTO.getConfigurations().isPrioritySupport());
            company.setConfigurations(configurations);
        }
        company = companyRepository.save(company); // Save company and get the generated ID

        // Add vehicles if provided
        if (companyDTO.getVehicles() != null) {
            for (VehicleDTO vehicleDTO : companyDTO.getVehicles()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setCompanyId(company.getId()); // Associate with the newly onboarded company
                vehicle.setType(vehicleDTO.getType());
                vehicle.setModel(vehicleDTO.getModel());
                vehicleRepository.save(vehicle);
            }
        }
    }
}