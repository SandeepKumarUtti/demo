package com.example.practiceproject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.practiceproject.demo.Entities.Devices;
import com.example.practiceproject.demo.Services.DeviceService;

@RestController
@RequestMapping(path = "/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping(path = "/allDevices")
    public Iterable<Devices> getAllDevices() {
        return deviceService.allDevices();
    }
    @PostMapping(path = "/addNewDevice")
    public void addDevice(@RequestBody Devices devices){
        deviceService.addNewDevices(devices);
    }
}
