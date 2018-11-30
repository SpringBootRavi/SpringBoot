package com.iss.buildingrestservices.controller;

import com.iss.buildingrestservices.domain.Employee;
import com.iss.buildingrestservices.domain.EmployeeNotFoundException;
import com.iss.buildingrestservices.repository.IEmployeeRepository;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{id}")
    Employee getEmployeeByID(@PathVariable Long id){
       return repository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
    }

    @PostMapping("/saveEmployee")
    Employee saveEmployee(@RequestBody Employee employee){
        return repository.save(employee);
    }
    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }

    @PutMapping("/employees/id")
    Employee replaceEmployee(@RequestBody Employee newEmployee,@PathVariable Long id){
        return repository.findById(id).map(employee -> {
                employee.setFirstName(newEmployee.getFirstName());
               employee.setLastName(newEmployee.getLastName());
               return repository.save(employee);
        }).orElseGet(()->{newEmployee.setId(id);
                           return repository.save(newEmployee);});
    }


}

