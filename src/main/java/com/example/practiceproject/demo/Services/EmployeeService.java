package com.example.practiceproject.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practiceproject.demo.Entities.Employee;
import com.example.practiceproject.demo.Repository.EmployeeRepository;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public EmployeeService() {

    }

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeByID(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployeeDetails(Long id, Employee employee) {
        Employee updatedEmployee = employeeRepository.findById(id).orElse(employee);
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        updatedEmployee.setEmail(employee.getEmail());
        employeeRepository.save(updatedEmployee);
        return updatedEmployee;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void deleteAllEmployees() {
      employeeRepository.deleteAll();
    }
}
