package com.iss.buildingrestservices.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employee {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;

    public Employee(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }



}
