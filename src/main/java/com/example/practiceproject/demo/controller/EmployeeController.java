package com.example.practiceproject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.practiceproject.demo.Dto.AuthRequest;
import com.example.practiceproject.demo.Entities.Employee;
import com.example.practiceproject.demo.Services.EmployeeService;
import com.example.practiceproject.demo.Services.JwtService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private JwtService pJwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    
    @GetMapping(path = "/admin/all")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public @ResponseBody Iterable<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }
    
    @GetMapping(path = "/user/getEmployeeById")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Employee getEmployeeById(@PathParam("id") Long id) {
        return employeeService.getEmployeeByID(id);
    }

    @PostMapping(path = "/addNewUser")
    public void postEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping(value = "path/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public void putMethodName(@PathParam("id") Long id, @RequestBody Employee employee) {
        employeeService.updateEmployeeDetails(id, employee);
    }

    @DeleteMapping(value = "path/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void DeleteEmployee(@PathParam("id") Long id) {
        employeeService.deleteEmployee(id);
    }


    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
         Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
         if (authentication.isAuthenticated()) {
            return pJwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
}
