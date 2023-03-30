package com.example.testhiber.service;

import com.example.testhiber.modelHiber.Device;
import com.example.testhiber.modelHiber.DeviceProjection;
import com.example.testhiber.modelHiber.ManufactureProjection;
import com.example.testhiber.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService
{
    @Autowired
    DeviceRepository deviceRepository;


    public Device createDevice(Device device)
    {
        return deviceRepository.save(device);
    }

    public void delDevice(Long id)
    {
        deviceRepository.deleteById(id);
    }

    public List<Device> findAll()
    {
        return deviceRepository.findAll();
    }


    public void saveAll(List<Device> devices)
    {
        deviceRepository.saveAll(devices);
    }
    public void delDeviceViaManufactureId(Long manufacture_id)
    {
        List<Device> devices = deviceRepository.findByManufactureId(manufacture_id);
        deviceRepository.deleteAll(devices);
    }

    public List<Device> findByNameLike(String name)
    {
        return deviceRepository.findByNameLike("%"+ name + "%");
    }
    public List<DeviceProjection> findAllDeviceProjection()
    {
        return deviceRepository.findAllBy();
    }
}
