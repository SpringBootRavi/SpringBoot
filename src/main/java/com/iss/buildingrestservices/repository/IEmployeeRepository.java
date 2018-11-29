package com.iss.buildingrestservices.repository;

import com.iss.buildingrestservices.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

}
