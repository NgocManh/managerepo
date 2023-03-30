package com.example.testhiber.controller;

import com.example.testhiber.exception.UserNotFoundException;
import com.example.testhiber.modelHiber.Device;
import com.example.testhiber.modelHiber.DeviceInfoProjection;
import com.example.testhiber.modelHiber.Manufacture;
import com.example.testhiber.modelHiber.ManufactureProjection;
import com.example.testhiber.service.DeviceService;
import com.example.testhiber.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("manu")
public class ManufactureController {

    @Autowired
    ManufactureService manufactureService;

    @Autowired
    DeviceService deviceService;

    @GetMapping("del/{id}")
    List<ManufactureProjection> delId(@PathVariable(name = "id") Long id)
    {

//        deviceService.delDeviceViaManufactureId(id);
        manufactureService.delManu(id);
        return manufactureService.findAllManuProjection();
    }



    @GetMapping("getAll")
    List<ManufactureProjection> findALl()
    {
        return manufactureService.findAllManuProjection();
    }

    @GetMapping("getAlls")
    List<Manufacture> findALlManu()
    {
        return manufactureService.findAll();
    }


    //http://localhost:8080/manu/like?name=L112&page=1
    @GetMapping(value = "like")
    List<ManufactureProjection> getListDeviceInfoImeiLike(@RequestParam(name = "name") String name, @RequestParam(name="page") int pageNum) throws UserNotFoundException
    {
        return manufactureService.findByNameLike(name,0);
    }
}
