package com.example.project.lifecycle;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

public interface TestInterfaceDynamicTestsDemo {

	@TestFactory
	default Stream<DynamicTest> dynamicTestForPalindromes() {
		return Stream.of("racecar", "radar", "mom", "dad")
				.map(text -> dynamicTest(text, () -> assertTrue(isPalindrome(text))));	
	}
	
    default boolean isPalindrome(String text) {
        // 펠린드롬 여부를 확인하는 로직을 작성합니다.
        // 예를 들어, 문자열을 뒤집어서 원래 문자열과 비교하여 같은지 확인하는 방법을 사용할 수 있습니다.
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }
   }
