package com.example.project;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledTestsDemo {

	// disabled를 사용해서 테스트를 수행하지 않을 수 있음
	// 테스트 실패에 대한 명확안 이유를 제공해 주는 것이 좋다.
	@Disabled("Disabled until bug #42 has been resolved")
	@Test
	void testWillBeSkipped() {
		
	}
	
	@Test
	void testWillBeExecuted() {
		
	}
}
