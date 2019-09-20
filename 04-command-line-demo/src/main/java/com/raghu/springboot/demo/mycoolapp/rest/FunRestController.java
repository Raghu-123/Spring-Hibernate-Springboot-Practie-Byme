package com.raghu.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	//expose "/" that return "Hello World!"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on the server is "+LocalDateTime.now();
	}
	
	//expose a  new endpoint for "workout"
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		
		return "Run Hard 5k";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		
		return "TOday is your lucky day!";
	}

}
