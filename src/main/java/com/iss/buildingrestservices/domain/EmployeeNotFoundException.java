package com.iss.buildingrestservices.domain;

public class EmployeeNotFoundException extends RuntimeException {
   public  EmployeeNotFoundException(Long id){
        super("Could not find Employee " + id);
    }
}
