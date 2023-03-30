package com.example.testhiber.modelHiber;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "device")
@Builder
@Data
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Long quantity;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacture_id", referencedColumnName = "id")
    Manufacture manufacture;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catagory_id", referencedColumnName = "id")
    Category category;

    @JsonManagedReference
    @OneToMany(mappedBy = "device", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    List<DeviceInfo> deviceInfoList = new ArrayList<>();

    public Device(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
