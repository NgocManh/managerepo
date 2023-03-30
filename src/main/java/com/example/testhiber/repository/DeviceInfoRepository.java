package com.example.testhiber.repository;

import com.example.testhiber.modelHiber.DeviceInfo;
import com.example.testhiber.modelHiber.DeviceInfoProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface DeviceInfoRepository extends JpaRepository<DeviceInfo, Long> {

    List<DeviceInfoProjection> findByImeiLike(String imei, Pageable pageable);

    List<DeviceInfoProjection> findAllBy();

}
