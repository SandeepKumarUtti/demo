package com.example.practiceproject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practiceproject.demo.EmployeeDataHandle;
import com.example.practiceproject.demo.EmployeesStorageClass;
import com.example.practiceproject.demo.Entities.Employee;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDataHandle employeeDataHandle;
    
    @GetMapping(path = "/")
    public EmployeesStorageClass getEmployees() {
        return employeeDataHandle.getAllEmployees();
    }

    @GetMapping(path = "/getEmployeeById")
    public Employee getEmployeeById(@PathParam("id") Integer id) {
        return employeeDataHandle.getEmployeeById(id-1);
    }

    @PostMapping(path = "/")
    public void postEmployee(@RequestBody Employee employee) {
        Integer id = employeeDataHandle.getAllEmployees().getEmployeeList().size() + 1;
        employee.setId(id);
        employeeDataHandle.addEmployee(employee);
    }

    @PutMapping(value="path/{id}")
    public void putMethodName(@PathParam("id") Integer id, @RequestBody Employee employee) {
        //TODO: process PUT request
        Employee updateEmployee = employeeDataHandle.getEmployeeById(id - 1);
        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmail(employee.getEmail());
    }
}
