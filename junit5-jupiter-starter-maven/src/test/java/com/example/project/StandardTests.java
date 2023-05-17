package com.example.project;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class StandardTests {

	// 현재 클래스의 모든 메서드 보다 먼저 실행되어야 함
	@BeforeAll
	static void initAll() {
		
	}
	
	// 현재 클래스의 각 메소드의 전에 실행되어야 함
	@BeforeEach
	void init() {
		
	}
	
	@Test
	void succeedingTest() {
		
	}
	
	@Test
    void failingTest() {
        fail("a failing test");
    }
	@Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }
	
	@Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

	// 현재 클래스의 각 메소드의 후에 실행되어야 함
    @AfterEach
    void tearDown() {
    }

    // 현재 클래스의 모든 메소드 보다 먼저 실행되어야 함
    @AfterAll
    static void tearDownAll() {
    }
	
	
}
