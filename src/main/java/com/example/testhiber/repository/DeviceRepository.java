package com.example.testhiber.repository;

import com.example.testhiber.modelHiber.Device;
import com.example.testhiber.modelHiber.DeviceInfo;
import com.example.testhiber.modelHiber.DeviceProjection;
import com.example.testhiber.modelHiber.ManufactureProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    List<Device> findByManufactureId(Long manufacture_id);
    List<DeviceProjection> findAllBy();

    List<Device> findByNameLike(String name);
//    public void delele
}
