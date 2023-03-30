package com.example.testhiber;

import com.example.testhiber.controller.FeighTest;
import com.example.testhiber.event.TestListener;
import com.example.testhiber.modelHiber.Category;
import com.example.testhiber.modelHiber.Device;
import com.example.testhiber.modelHiber.Manufacture;
import com.example.testhiber.service.CartService;
import com.example.testhiber.service.CategoryService;
import com.example.testhiber.service.DeviceService;
import com.example.testhiber.service.ManufactureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableFeignClients
@EnableAsync
public class TesthiberApplication implements CommandLineRunner {

	@Autowired
	TestListener publisher;
	@Autowired
	DeviceService deviceService;

	@Autowired
	ManufactureService manufactureService;

	@Autowired
	CategoryService categoryService;

	private static Logger LOG = LoggerFactory
			.getLogger(TesthiberApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(TesthiberApplication.class, args);

	}

	@Override
	public void run(String... args) {
	}

	// write function check number is prime or not
	@Bean
	TaskExecutor taskExecutor() {
		return new SimpleAsyncTaskExecutor();
	}
}
