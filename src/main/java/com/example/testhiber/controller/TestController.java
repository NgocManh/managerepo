package com.example.testhiber.controller;

import com.example.testhiber.aop.RequireRole;
import com.example.testhiber.event.QueryEvent;
import com.example.testhiber.exception.UserNotFoundException;
import com.example.testhiber.model.Cart;
import com.example.testhiber.model.Item;
import com.example.testhiber.model.Response;
import com.example.testhiber.modelHiber.Category;
import com.example.testhiber.modelHiber.Device;
import com.example.testhiber.modelHiber.Manufacture;
import com.example.testhiber.repository.CartRepository;
import com.example.testhiber.service.CartService;
import com.example.testhiber.service.CategoryService;
import com.example.testhiber.service.DeviceService;
import com.example.testhiber.service.ManufactureService;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    ApplicationEventPublisher publisher;

    @Autowired
    FeighTest feighTest;

    @Autowired
    DeviceService deviceService;

    @Autowired
    CartService cartService;

    @Autowired
    ManufactureService manufactureService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    String test()
    {
        return "ahihi";
    }

    @GetMapping("add")
    void addCart()
    {
        Item item = new Item("Item 1");
        Item item2 = new Item("Item 2");

        Set<Item> items = new HashSet<>();
        items.add(item);
        items.add(item2);

        Cart cart = new Cart();
        cart.setItems(items);

        item.setCart(cart);
        item2.setCart(cart);

        cartService.create(cart);
    }


    @GetMapping("del/{id}")
    void del(@PathVariable(name = "id") Long id)
    {
        cartService.delete(id);
    }

    @GetMapping("init")
    void init()
    {
        Category tablet = categoryService.createCategory(Category.builder().name("Tablet").build());
        Category smartphone = categoryService.createCategory(Category.builder().name("Smartphone").build());



        Manufacture xiaomi = manufactureService.createManufacture(Manufacture.builder().name("Xiaomi").build());
        Manufacture samsung = manufactureService.createManufacture(Manufacture.builder().name("Samsung").build());
        Manufacture apple = manufactureService.createManufacture(Manufacture.builder().name("Apple").build());


        Device a12 = Device.builder()
                .name("a12f")
                .quantity(10L)
                .category(smartphone)
                .manufacture(samsung)
                .build();

        deviceService.createDevice(a12);


        Device s22 = Device.builder()
                .name("s22145F")
                .quantity(10L)
                .category(smartphone)
                .manufacture(samsung)
                .build();

        deviceService.createDevice(s22);

        Device a23 = Device.builder()
                .name("a23L")
                .quantity(10L)
                .category(smartphone)
                .manufacture(samsung)
                .build();

        deviceService.createDevice(a23);

        Device tabS7 = Device.builder()
                .name("Tab s7")
                .quantity(5L)
                .category(tablet)
                .manufacture(xiaomi)
                .build();

        deviceService.createDevice(tabS7);

        Device ipadGen9 = Device.builder()
                .name("Ipad Gen 9")
                .quantity(1L)
                .category(tablet)
                .manufacture(apple)
                .build();

        deviceService.createDevice(ipadGen9);
    }


    @GetMapping(value = "test",

            produces = MediaType.APPLICATION_JSON_VALUE)
    Response test2()
    {
        Response x = Response.builder().status(200).massage("ô cê").build();
        //return
        return x;
    }

    @GetMapping(value = "test3",

            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Response> test3()
    {
        Response x = Response.builder().status(200).massage("ô cê").build();
        //return
        return new ResponseEntity<>(x, HttpStatus.ACCEPTED);
    }


    @GetMapping(value = "testFeigh")
    List<Device> testFeigh()
    {
        List<Device> list = feighTest.getAllDevices();
        System.out.println("------------------");
        List<Device> res = new ArrayList<>();
        list.stream().forEach(d ->{
            res.add(Device.builder().name(d.getName()).quantity(d.getQuantity()).build());
        });

        System.out.println("------------------");

        return res;
    }


    @GetMapping(value = "testFeigh2")
    List<Device> testFeigh2()
    {
        List<Device> list = deviceService.findAll();

//        List<Device> res = new ArrayList<>();
//        list.stream().forEach(d ->{
//            res.add(Device.builder().name(d.getName()).quantity(d.getQuantity()).build());
//        });

        return list;
    }



    @RequireRole(value = "user")
    @GetMapping("check")
    Response testPermission()
    {
        publisher.publishEvent(new QueryEvent(this));
        return new Response(200, "olala");
    }


}
