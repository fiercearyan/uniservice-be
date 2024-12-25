package com.uniservice.service;

import com.uniservice.entity.Person;
import com.uniservice.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public Person createPerson(Person person) {
        return personRepo.save(person);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Person person = personRepo.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
        person.setName(personDetails.getName());
        person.setPhoneNumber(personDetails.getPhoneNumber());
        return personRepo.save(person);
    }

    public List<Person> getAllPersons() {
        return personRepo.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepo.findById(id);
    }

    public void deletePerson(Long id) {
        personRepo.deleteById(id);
    }
}