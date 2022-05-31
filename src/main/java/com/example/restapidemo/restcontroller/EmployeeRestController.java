package com.example.restapidemo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/twoapi")
public class EmployeeRestController {

//    private final EmployeeService employeeService;

    private RestTemplate restTemplate;

    @Autowired
    public EmployeeRestController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

//    @Autowired
//    public EmployeeRestController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }

    @GetMapping("/employees")
    public ResponseEntity<List<Object>> findAll(){
        String url = "http://dummy.restapiexample.com/api/v1/employees";


        return new ResponseEntity<>(Arrays.asList(restTemplate.getForEntity(url, Object.class)), HttpStatus.OK);
//        return Arrays.asList(obj);
    }


//    @GetMapping("/employees/group/age")
//    public ResponseEntity<List<Employee>> groupByAge(){
//        return new ResponseEntity<>(employeeService.groupByAge(),HttpStatus.OK);
//    }
}

//        List<Employee> employees = employeeService.findByAgeLargerThan(age);
//
//        if(employees == null){
//            throw new RuntimeException("No one is older than this age!");
//        }