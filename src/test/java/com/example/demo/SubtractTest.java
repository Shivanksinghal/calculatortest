package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubtractTest {

	@Autowired
	CalculatorController controller;
	
//	@Test
//	public void testSubtractSuccess() {
//		String a = "10000";
//		String b = "10000";
//		
//		int result = controller.subtract(a, b);
//		assertEquals(0, result);
//	}
	
	@Test
	public void testSubtractWithWrongParameters() {
		assertThrows(NumberFormatException.class, () -> {
			String a = "100";
			String b = "xx";
			
			controller.subtract(a, b);
			controller.subtract(b, a);
		});
	}
	
	@Test
	void testSubtractWithIntegerOverflow() {
		String a = "-2147483647";
		String b = "2147483647";
		
		int result = controller.subtract(a, b);
		
		assertNotEquals(-4294967294l, result);
	}

}
