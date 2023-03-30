package com.example.testhiber.service;

import com.example.testhiber.modelHiber.Device;
import com.example.testhiber.modelHiber.DeviceInfo;
import com.example.testhiber.modelHiber.DeviceInfoProjection;
import com.example.testhiber.repository.DeviceInfoRepository;
import com.example.testhiber.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class DeviceInfoService {

    @Autowired
    DeviceInfoRepository deviceInfoRepository;


    public void saveAll(List<DeviceInfo> list)
    {
        deviceInfoRepository.saveAll(list);
    }

    public List<DeviceInfoProjection> findByImeiLike(String imei, int pageNum)
    {
        return deviceInfoRepository.findByImeiLike("%"+ imei + "%", PageRequest.of(pageNum,5));
    }
}
