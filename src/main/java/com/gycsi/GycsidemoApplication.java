package com.gycsi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class GycsidemoApplication {

	@RequestMapping("/")
	@ResponseBody
	String gary(){
		return "hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(GycsidemoApplication.class, args);
	}
}
