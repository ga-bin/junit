package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;

@DisplayName("TestInfo Demo")
public class TestInfoDemo {

	public TestInfoDemo(TestInfo testInfo) {
		assertEquals("TestInfo Demo", testInfo.getDisplayName());
	}
	
	@BeforeEach
	void init(TestInfo testInfo) {
		String displayName = testInfo.getDisplayName();
		assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
	}
	
	
}
