package com.example.demo.services;

import com.example.demo.models.Person;
import com.example.demo.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person readById(Long id) {
        return personRepository.findById(id).get();
    }

    public List<Person> readAll() {
        Iterable<Person> personIterable = personRepository.findAll();
        List<Person> result = new ArrayList<>();
        personIterable.forEach(result::add);
        return result;
    }

    public Person updateById(Long id, Person newData) {
        Person personToUpdate = readById(id);
        personToUpdate.setId(newData.getId());
        personToUpdate.setName(newData.getName());
        return personRepository.save(personToUpdate);
    }

    public Person deleteById(Long id) {
        Person personToDelete = readById(id);
        personRepository.delete(personToDelete);
        return personToDelete;
    }
}
