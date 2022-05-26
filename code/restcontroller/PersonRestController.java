package com.example.restapidemo.restcontroller;

import com.example.restapidemo.entity.Person;
import com.example.restapidemo.exception.PersonNotFoundException;
import com.example.restapidemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonRestController {

    private PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/people")
    public ResponseEntity<List<Person>>findAll(){
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getPersonById(@PathVariable int personId){
        Person person = personService.findById(personId);
        if(person == null){
            throw new PersonNotFoundException("Person Not Found with ID - " + personId);
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        person.setId(0);
        personService.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person){
        personService.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<String> deletePerson(@PathVariable int personId){
        Person person = personService.findById(personId);
        if(person == null){
            throw new PersonNotFoundException("Person with ID " + personId + " not found!");
        }
        personService.deleteById(personId);
        return new ResponseEntity<>("Delete Person with ID " + personId + " was deleted!", HttpStatus.OK);
    }


}
