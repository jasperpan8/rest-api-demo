package com.example.restapidemo.restcontroller;

import com.example.restapidemo.entity.House_Person;
import com.example.restapidemo.exception.HousePersonNotFoundException;
import com.example.restapidemo.service.HousePersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/housePerson/")
public class HousePersonRestController {

    private HousePersonService housePersonService;

    @Autowired
    public HousePersonRestController(HousePersonService housePersonService) {
        this.housePersonService = housePersonService;
    }

    @GetMapping("/HousePeople")
    public ResponseEntity<List<House_Person>> findAll(){
        return new ResponseEntity<>(housePersonService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{housePersonId}")
    public ResponseEntity<House_Person> findById(@PathVariable int housePersonId){
        House_Person housePerson = housePersonService.findById(housePersonId);

        if(housePerson == null){
            throw new HousePersonNotFoundException("House_Person with Id " + housePersonId + " is not found!");
        }
        return new ResponseEntity<>(housePerson,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<House_Person> addHousePerson(@RequestBody House_Person housePerson){
        // just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        housePerson.setId(0);
        housePersonService.save(housePerson);
        return new ResponseEntity<>(housePerson,HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<House_Person> updateHousePerson(@RequestBody House_Person housePerson){
        housePersonService.save(housePerson);
        return new ResponseEntity<>(housePerson,HttpStatus.OK);
    }

    @DeleteMapping("/{housePersonId}")
    public ResponseEntity<String> deleteById(@PathVariable int housePersonId){
        House_Person housePerson = housePersonService.findById(housePersonId);
        if(housePerson == null){
            throw new HousePersonNotFoundException("House_Person with Id " + housePersonId + " is not found!");
        }
        return new ResponseEntity<>("Delete Person with ID " + housePersonId + " was deleted!", HttpStatus.OK);
    }
}
