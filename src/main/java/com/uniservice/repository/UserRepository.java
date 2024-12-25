package com.uniservice.repository;

import com.uniservice.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    User save(User user);

    @Override
    List<User> findAll();

    Optional<User> findById(String id);

    void deleteById(String id);
}