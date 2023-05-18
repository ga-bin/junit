package com.example.project.parameter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class MethodSourceTests {

	@ParameterizedTest
	// 스트림 내의 인수 집합이 어노테이션이 있는 메소드의 개별 호출에 대한 물리적 인수로 전달된다.
	@MethodSource("stringProvider")
	void testWithExplicitLocalMethodSource(String argument) {
		assertNotNull(argument);
	}
	
	// 팩토리 메소드는 인수 스트림을 형성해야 한다.
	static Stream<String> stringProvider() {
		return Stream.of("apple", "banana");
	}
	
	// 메소드 소스의 이름이 명시적으로 제공되어 있지 않을 경우 동일한 이름을 가진 팩토리 메소드를 검색해서 집어넣는다.
	@ParameterizedTest
	@MethodSource
	void testWithDefaultLocalMethodSource(String argument) {
	    assertNotNull(argument);
	}

	static Stream<String> testWithDefaultLocalMethodSource() {
	    return Stream.of("apple", "banana");
	}
	
	@ParameterizedTest
	@MethodSource("range")
	void testWithRangeMethodSource(int argument) {
	    assertNotEquals(9, argument);
	}

	static IntStream range() {
	    return IntStream.range(0, 20).skip(10);
	}
	
	// 테스트 메소드 소스가 여러개의 매개변스를 선언하는 경우에는 객체 배열, 스트림, 배열을 반환해야 한다.
	@ParameterizedTest
	@MethodSource("stringIntAndListProvider")
	void testWithMultiArgMethodSource(String str, int num, List<String> list) {
	    assertEquals(5, str.length());
	    assertTrue(num >=1 && num <=2);
	    assertEquals(2, list.size());
	}

	static Stream<Arguments> stringIntAndListProvider() {
	    return Stream.of(
	        arguments("apple", 1, Arrays.asList("a", "b")),
	        arguments("lemon", 2, Arrays.asList("x", "y"))
	    );
	}
}
