package com.example.project.order;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

public class TestReporterDemo {

	// testReporter를 통해서 테스트 결과에 대한 보고서를 생성하고 외부 코드에 삽입할 수 있따.
	@Test
	void reportSingleValue(TestReporter testReporter) {
		testReporter.publishEntry("a satus message");
	}
	
	@Test
	void reortKeyValuePair(TestReporter testReporter) {
		testReporter.publishEntry("a key", "a value");
	}
	
	@Test
	void reportMultipleKeyValuePairs(TestReporter testReporter) {
		Map<String, String> values = new HashMap<>();
		values.put("user name", "dk38");
		values.put("award year", "1974");
		
		testReporter.publishEntry(values);
}
}
