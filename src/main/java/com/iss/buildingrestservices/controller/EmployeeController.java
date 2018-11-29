package com.iss.buildingrestservices.controller;

import com.iss.buildingrestservices.domain.Employee;
import com.iss.buildingrestservices.repository.IEmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController
{
    private final IEmployeeRepository repository;

    EmployeeController(IEmployeeRepository repository){
        this.repository = repository;
    }
    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/employees")
    List<Employee> getEmployees(){
        return repository.findAll();
    }
}

