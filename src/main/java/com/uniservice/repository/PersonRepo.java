package com.uniservice.repository;

import com.uniservice.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepo extends MongoRepository<Person, Long> {

    @Override
    Person save(Person person);

    @Override
    List<Person> findAll();

    @Override
    Optional<Person> findById(Long aLong);

    @Override
    void deleteById(Long aLong);
}