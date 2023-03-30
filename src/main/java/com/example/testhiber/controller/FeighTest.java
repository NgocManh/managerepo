package com.example.testhiber.controller;

import com.example.testhiber.modelHiber.Device;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "test", url = "http://localhost:8080")
public interface FeighTest {

    @GetMapping("/device/getAll")
    public List<Device> getAllDevices();

}
