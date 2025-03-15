package com.example.jpa_demo.service;

import com.example.jpa_demo.dto.PersonDTO;
import com.example.jpa_demo.dto.PersonRequestDTO;
import com.example.jpa_demo.entity.PersonEntity;
import com.example.jpa_demo.exception.ResourceNotFoundException;
import com.example.jpa_demo.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class PersonService {

    // @AllArgsConstructor, @RequiredArgsConstructor handles the below
//    @Autowired

//    @Autowired
//    public PersonService(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // performing operations

    public void addPerson(PersonRequestDTO request) {


        String fullName = request.getFullName();

        String[] splittedName = fullName.split(" ");

        PersonEntity personEntity = new PersonEntity();


        personEntity.setDateOfBirth(request.getDob());
        personEntity.setFirstname(splittedName[0]);
        personEntity.setLastname(splittedName[splittedName.length - 1]);


        personRepository.save(personEntity);
    }

    public void updatePerson(String id, PersonRequestDTO request){
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
        if(personEntityOptional.isEmpty()){
            throw new ResourceNotFoundException("person not found");
        }

        PersonEntity personEntity = personEntityOptional.get();

        String fullName = request.getFullName();
        String[] splittedName = fullName.split(" ");


        personEntity.setDateOfBirth(request.getDob());
        personEntity.setFirstname(splittedName[0]);
        personEntity.setLastname(splittedName[splittedName.length - 1]);

        personRepository.save(personEntity);
    }

    public PersonEntity getAPerson(String id){
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
        if (personEntityOptional.isEmpty()){
            throw new ResourceNotFoundException("person not found");

        }
        return personEntityOptional.get();
    }

    public List<PersonDTO> getAllPerson(){

        List<PersonDTO> persons = new ArrayList<>();
        List<PersonEntity> allPerson = personRepository.findAll();
        for (PersonEntity person: allPerson){
            PersonDTO personDTO = new PersonDTO();
            personDTO.setDob(person.getDateOfBirth());
            personDTO.setId(person.getId());
            personDTO.setFullName(person.getFirstname() + " " + person.getLastname());

            persons.add(personDTO);
        }

        return persons;

    }

    public void deletePerson(String id){

        personRepository.deleteById(id);
    }


}

