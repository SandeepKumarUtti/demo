package com.example.practiceproject.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practiceproject.demo.Entities.Address;
import com.example.practiceproject.demo.Services.AddressService;

@RestController
@RequestMapping(path = "/address")
public class AddressController {

    @Autowired
    AddressService addressService;

     @GetMapping(path = "/allAddress")
    public Iterable<Address> getEmployees() {
        return addressService.getAddresses();
    }
    
}
