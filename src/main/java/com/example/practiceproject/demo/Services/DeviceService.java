package com.example.practiceproject.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practiceproject.demo.Entities.Devices;
import com.example.practiceproject.demo.Repository.DeviceRepository;

@Service
public class DeviceService {
    
    @Autowired
    DeviceRepository deviceRepository;

    public DeviceService() {
    }

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Devices> allDevices() {
        return deviceRepository.findAll();
    }

    public Devices addNewDevices(Devices devices) {
        return deviceRepository.save(devices);
    }


}
