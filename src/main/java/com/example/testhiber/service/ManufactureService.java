package com.example.testhiber.service;

import com.example.testhiber.exception.UserNotFoundException;
import com.example.testhiber.modelHiber.Device;
import com.example.testhiber.modelHiber.DeviceInfoProjection;
import com.example.testhiber.modelHiber.Manufacture;
import com.example.testhiber.modelHiber.ManufactureProjection;
import com.example.testhiber.repository.DeviceRepository;
import com.example.testhiber.repository.ManufactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureService {
    @Autowired
    ManufactureRepository manufactureRepository;

    public Manufacture createManufacture(Manufacture device)
    {
        return manufactureRepository.save(device);
    }

    public void delManu(Long id)
    {
        manufactureRepository.deleteById(id);
    }

    public List<Manufacture> findAll()
    {
        return manufactureRepository.findAll();
    }

    public List<ManufactureProjection> findAllManuProjection()
    {
        return manufactureRepository.findAllBy();
    }

    public List<ManufactureProjection> findByNameLike(String name, int pageNum)
    {
        List<ManufactureProjection> list = manufactureRepository.findByNameLike("%"+ name + "%", PageRequest.of(pageNum,5));

        if(list.size() == 0)
            throw new UserNotFoundException("no hope!");

        return list;
    }
}
