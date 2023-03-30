package com.example.testhiber.controller;

import com.example.testhiber.modelHiber.DeviceInfo;
import com.example.testhiber.modelHiber.DeviceInfoProjection;
import com.example.testhiber.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("di")
@RestController
public class DeviceInfoController {

    @Autowired
    DeviceInfoService deviceInfoService;


    //http://localhost:8080/di/like?imei=L112&page=1
    @GetMapping(value = "like")
    List<DeviceInfoProjection> getListDeviceInfoImeiLike(@RequestParam(name = "imei") String imei, @RequestParam(name="page") int pageNum)
    {
        List<DeviceInfoProjection> deviceInfo = deviceInfoService.findByImeiLike(imei, pageNum);

        return deviceInfo;
    }
}
