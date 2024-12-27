package com.uniservice.controller;

import com.uniservice.dto.VehicleDTO;
import com.uniservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    // Add a vehicle separately
    @PostMapping("/add")
    public ResponseEntity<String> addVehicle(@RequestBody VehicleDTO vehicleDTO) {
        vehicleService.addVehicle(vehicleDTO);
        return ResponseEntity.ok("Vehicle added successfully!");
    }

    @PostMapping("/{vehicleId}/add-to-user/{userId}")
    public ResponseEntity<String> addVehicleToUser(@PathVariable String vehicleId, @PathVariable String userId) {
        vehicleService.addVehicleToUser(vehicleId, userId);
        return ResponseEntity.ok("Vehicle added to user successfully!");
    }
}