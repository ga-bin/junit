package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyfirstJUnitJupiterTests {

	private final Calculator calculator = new Calculator();
	
	@Test
	void addition() {
		assertEquals(2, calculator.add(1, 1));
	}
}
