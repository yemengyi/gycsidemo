package com.gycsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class GycsidemoApplication {


	@RequestMapping("/")
	@ResponseBody
	String hello(){
		return "hello sping boot";
	}

	public static void main(String[] args) {
		SpringApplication.run(GycsidemoApplication.class, args);
	}


}
