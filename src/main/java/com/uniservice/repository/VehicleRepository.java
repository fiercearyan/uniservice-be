package com.uniservice.repository;

import com.uniservice.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    @Override
    Optional<Vehicle> findById(String s);

    List<Vehicle> findByCompanyId(String companyId);

}