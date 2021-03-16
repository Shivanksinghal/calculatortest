package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddTest {

	@Autowired
	CalculatorController controller;
	
	@Test
	public void testAddSuccess() {
		String a = "999";
		String b = "10000";
		
		int result = controller.add(a, b);
		assertEquals(10999, result);
	}
	
	@Test
	public void testAddWithWrongParameters() {
		assertThrows(NumberFormatException.class, () -> {
			String a = "100";
			String b = "xx";
			
			controller.add(a, b);
			controller.add(b, a);
		});
	}
	
	@Test
	void testAddWithIntegerOverflow() {
		String a = "2147483647";
		String b = "2147483647";
		
		int result = controller.add(a, b);
		
		assertNotEquals(4294967294l, result);
	}

}
