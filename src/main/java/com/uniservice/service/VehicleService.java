package com.uniservice.service;

import com.uniservice.dto.VehicleDTO;
import com.uniservice.entity.User;
import com.uniservice.entity.Vehicle;
import com.uniservice.repository.CompanyRepository;
import com.uniservice.repository.UserRepository;
import com.uniservice.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    public void addVehicle(VehicleDTO vehicleDTO) {
        // Validate that the company exists
        if (!companyRepository.existsById(vehicleDTO.getCompanyId())) {
            throw new RuntimeException("Invalid companyId: Company does not exist!");
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setCompanyId(vehicleDTO.getCompanyId());
        vehicle.setType(vehicleDTO.getType());
        vehicle.setModel(vehicleDTO.getModel());
        vehicleRepository.save(vehicle);
    }

    public void addVehicleToUser(String vehicleId, String userId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        vehicle.getUsers().add(user);
        user.getVehicles().add(vehicle);
        vehicleRepository.save(vehicle);
        userRepository.save(user);
    }
}