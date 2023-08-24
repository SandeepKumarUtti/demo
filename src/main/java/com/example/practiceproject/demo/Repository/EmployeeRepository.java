package com.example.practiceproject.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practiceproject.demo.Entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}