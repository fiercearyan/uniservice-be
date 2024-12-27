package com.uniservice.repository;

import com.uniservice.entity.ServiceCenter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceCenterRepository extends MongoRepository<ServiceCenter, String> {
}