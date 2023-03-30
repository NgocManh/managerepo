package com.example.testhiber.configure;

import com.example.testhiber.modelHiber.*;
import com.example.testhiber.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
public class InitConfig {

    @Autowired
    DeviceService deviceService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ManufactureService manufactureService;


    @Autowired
    DeviceInfoService deviceInfoService;
    @Autowired
    UserService userService;

    @PostConstruct
    public void initData()
    {
        initDevices();
        initUsers();
    }


    void initUsers()
    {
        User user = User.builder().email("ngocmanh.dev@gmail.com").role("user").password("123").build();
        User user2 = User.builder().email("ngocmanh.cntt3@gmail.com").role("user").password("123").build();
        userService.save(user);
        userService.save(user2);


    }
    void initDevices()
    {
        Random random = new Random();


        Category tablet = categoryService.createCategory(Category.builder().name("Tablet").build());
        Category smartphone = categoryService.createCategory(Category.builder().name("Smartphone").build());

        Manufacture xiaomi = manufactureService.createManufacture(Manufacture.builder().name("Xiaomi").build());
        Manufacture samsung = manufactureService.createManufacture(Manufacture.builder().name("Samsung").build());
        Manufacture apple = manufactureService.createManufacture(Manufacture.builder().name("Apple").build());


        IntStream.range(0,20).mapToObj(i ->

                {
                    String code = String.valueOf(random.nextInt(100));
                    char c = (char) ('a' + random.nextInt(26));
                    String deviceName = "a"+code+c;

                    int sll = random.nextInt(5);

                    Device device = Device.builder().name(deviceName).quantity(Long.valueOf(sll)).category(smartphone).manufacture(samsung).build();

                    deviceService.createDevice(device);

                    List<DeviceInfo> deviceInfoList = IntStream.range(0,sll).mapToObj(j -> DeviceInfo.builder().device(device).imei(randomString()).serial("R32" + randomString()).state(1L).build()).collect(Collectors.toList());

                    deviceInfoService.saveAll(deviceInfoList);

                    return device;
                }

                ).collect(Collectors.toList());

//        deviceService.saveAll(deviceListASeries);

    }


    String randomString()
    {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString.toUpperCase();
    }
}

