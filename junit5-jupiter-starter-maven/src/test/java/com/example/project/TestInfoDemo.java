package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("TestInfo Demo")
public class TestInfoDemo {

	// 기존에는 생성자나 함수에 파라미터가 었을 수 없었는데 지원하기 시작하면서 종속성 주입히 활발해짐
	public TestInfoDemo(TestInfo testInfo) {
		assertEquals("TestInfo Demo", testInfo.getDisplayName());
	}
	
	@BeforeEach
	void init(TestInfo testInfo) {
		String displayName = testInfo.getDisplayName();
		assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
	}
	
	@Test
	@DisplayName("TEST 1")
	@Tag("my-tag")
	void test1(TestInfo testInfo) {
		assertEquals("TEST 1", testInfo.getDisplayName());
		assertTrue(testInfo.getTags().contains("my-tag"));
	}
	
	@Test
	void test2() {
		
	}
}
