package com.example.testhiber.controller;

import com.example.testhiber.modelHiber.Device;
import com.example.testhiber.modelHiber.DeviceInfo;
import com.example.testhiber.modelHiber.DeviceProjection;
import com.example.testhiber.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("d")
@RestController
public class DeviceController {

    @Autowired
    DeviceService deviceService;


//    @GetMapping("del/{id}")
//
//    List<DeviceProjection> delId(@PathVariable(name = "id") Long id)
//    {
//        deviceService.delDevice(id);
//        return deviceService.findAllDeviceProjection();
//    }
//
//    @GetMapping("delmanu/{id}")
//    List<DeviceProjection> delManuId(@PathVariable(name = "id") Long id)
//    {
//        deviceService.delDeviceViaManufactureId(id);
//        return deviceService.findAllDeviceProjection();
//    }

    @GetMapping("getAll")
    List<DeviceProjection> getAll()
    {
        List<DeviceProjection> list = deviceService.findAllDeviceProjection();
        return list;
    }

    @GetMapping(value = "like")
    List<Device> getListDeviceNameLike(@RequestParam(name = "name") String name)
    {
        return deviceService.findByNameLike(name);
    }
}
