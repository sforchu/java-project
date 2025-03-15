package com.example.jpa_demo.controller;

import com.example.jpa_demo.dto.PersonDTO;
import com.example.jpa_demo.dto.PersonRequestDTO;
import com.example.jpa_demo.entity.PersonEntity;
import com.example.jpa_demo.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<List<PersonDTO>> getAllPersons(){
        return new ResponseEntity<>(personService.getAllPerson(), HttpStatus.OK);
        //return ResponseEntity.ok(personService.getAllPerson());
    }

    @PostMapping("/person")
    public ResponseEntity<Void> addPerson(@RequestBody @Valid PersonRequestDTO requestDTO){
        personService.addPerson(requestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable("id") String id,  @RequestBody PersonRequestDTO requestDTO){
        personService.updatePerson(id, requestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
}
