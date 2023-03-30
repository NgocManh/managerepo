package com.example.testhiber.repository;

import com.example.testhiber.modelHiber.DeviceInfoProjection;
import com.example.testhiber.modelHiber.Manufacture;
import com.example.testhiber.modelHiber.ManufactureProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManufactureRepository extends JpaRepository<Manufacture, Long> {
    List<ManufactureProjection>  findAllBy();

    List<ManufactureProjection> findByNameLike(String name, Pageable pageable);
}
