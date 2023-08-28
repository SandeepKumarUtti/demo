package com.example.practiceproject.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.practiceproject.demo.Entities.Employee;
import com.example.practiceproject.demo.Repository.EmployeeRepository;

@Component
public class EmployeeDetailsService implements UserDetailsService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Optional<Employee> employeeinfo = employeeRepository.findByLastName(username);
        return employeeinfo.map(EmployeeInfoEmployeeDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found" + username));
        //throw new UnsupportedOperationException("Unimplemented method 'loadUserByUsername'");
    }
    
}
