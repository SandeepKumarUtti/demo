package com.example.practiceproject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.practiceproject.demo.Entities.Employee;
import com.example.practiceproject.demo.Services.EmployeeService;
import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;    
    
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }
    
    @GetMapping(path = "/getEmployeeById")
    public Employee getEmployeeById(@PathParam("id") Long id) {
        return employeeService.getEmployeeByID(id);
    }

    @PostMapping(path = "/")
    public void postEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping(value="path/{id}")
    public void putMethodName(@PathParam("id") Long id, @RequestBody Employee employee) {
        employeeService.updateEmployeeDetails(id, employee);
    }

    @DeleteMapping(value = "path/{id}")
    public void DeleteEmployee(@PathParam("id") Long id) {
        employeeService.deleteEmployee(id);
    }
}
