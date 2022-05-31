package com.example.restapidemo.restcontroller;

import com.example.restapidemo.entity.House;
import com.example.restapidemo.exception.HouseNotFoundException;
import com.example.restapidemo.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/house")
public class HouseRestController {

    private HouseService houseService;

    @Autowired
    public HouseRestController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping("/houses")
    public ResponseEntity<List<House>> findAll(){
        return new ResponseEntity<>(houseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{houseId}")
    public ResponseEntity<House> getHouseById(@PathVariable int houseId){
        House house = houseService.findById(houseId);
        if(house == null){
            throw new HouseNotFoundException("House with ID " + houseId + " not found!");
        }
        return new ResponseEntity<>(house,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<House> addHouse(@RequestBody House house){
        house.setId(0);
        houseService.save(house);
        return new ResponseEntity<>(house, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<House> updateHouse(@RequestBody House house){
        houseService.save(house);
        return new ResponseEntity<>(house, HttpStatus.OK);
    }

    @DeleteMapping("/{houseId}")
    public ResponseEntity<String> deleteHouse(@PathVariable int houseId){
        House house = houseService.findById(houseId);
        if(house == null){
            throw new HouseNotFoundException("House with ID " + houseId + " not found!");
        }
        houseService.deleteById(houseId);
        return new ResponseEntity<>("Delete House with ID " + houseId + " successfully",HttpStatus.OK);
    }
}
