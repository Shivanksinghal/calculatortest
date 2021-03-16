package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@GetMapping("/test")
	public String boo(@RequestParam("a") int a) {
		return "boo";
	}
	
	@RequestMapping("/add/{a}/{b}")
	public int add(@PathVariable String a, @PathVariable String b) {
			int num1 = Integer.parseInt(a);
			int num2 = Integer.parseInt(b);
			return num1 + num2;
	}
	
	@RequestMapping("/multiply/{a}/{b}")
	public int multiply(@PathVariable String a, @PathVariable String b) {
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
		return num1 * num2;
	}
	
	@RequestMapping("/subtract/{a}/{b}")
	public int subtract(@PathVariable String a, @PathVariable String b) {
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
		return num1 - num2;
	}
	
	@RequestMapping("/divide/{a}/{b}")
	public double divide(@PathVariable String a, @PathVariable String b) {
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
	
		if(num2 == 0) 
			return Double.MAX_VALUE;
		
		return (double) num1 / num2;
	}
}
