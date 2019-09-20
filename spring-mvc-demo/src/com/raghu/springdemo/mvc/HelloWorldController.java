package com.raghu.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	//need a controller method to show initial HTML form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	//new a controller method to read a form data
	
	//add data to the model
	@RequestMapping("/processFormTwo")
	public String letShoutDude(HttpServletRequest request, Model model) {
		//read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		//convert the data to UpperCase
		theName = theName.toUpperCase();
		
		//add the message
		String result = "Yo! " + theName;
		
		//add the message the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	// using the request param annotation
	@RequestMapping("/processFormThree")
	public String processFormThree(@RequestParam("studentName") String theName, Model model) {
		
		//convert the data to UpperCase
		theName = theName.toUpperCase();
		
		//add the message
		String result = "Hey my Friend " + theName;
		
		//add the message the model
		
		model.addAttribute("message",result);
		
		return "helloworld";
	}
}
