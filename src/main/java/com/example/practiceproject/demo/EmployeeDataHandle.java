package com.example.practiceproject.demo;

import org.springframework.stereotype.Repository;

import com.example.practiceproject.demo.Entities.Employee;

@Repository
public class EmployeeDataHandle {
    
    private static EmployeesStorageClass list = new EmployeesStorageClass();

    static
    {
        list.getEmployeeList().add(
            new Employee(
                1,
                "Prem",
                "Tiwari",
                "asdsknd@gmail.com"));
  
        list.getEmployeeList().add(
            new Employee(
                2, "Vikash",
                "Kumar",
                "abc@gmail.com"));
  
        list.getEmployeeList().add(
            new Employee(
                3, "Ritesh",
                "Ojha",
                "asdjf@gmail.com"));
  
           
    }
    
    public void addEmployee(Employee e) {
        list.getEmployeeList().add(e);
    }

    public Employee getEmployeeById(Integer id) {
        System.out.println("id"+id);
        return list.getEmployeeList().get(id);
    }

    public EmployeesStorageClass getAllEmployees() {
        return list;
    }

}
