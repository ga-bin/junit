package com.example.project.parameter;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.EnumSet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterTest {
	// 파라미터를 이용해 받복문을 실행할 수도 있다.
	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromes(String candidate) {
	    assertTrue(isPalindrome(candidate));
	}
	
    private boolean isPalindrome(String text) {
        // 펠린드롬 여부를 확인하는 로직을 작성합니다.
        // 예를 들어, 문자열을 뒤집어서 원래 문자열과 비교하여 같은지 확인하는 방법을 사용할 수 있습니다.
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }
    
    // 다음과 같이 인수들을 전달할 수도 있고, 인수들의 배열을 전달할 수도 있다
    // 이 로직은 인수의 배열을 전달하는 것으로 써 testWithValueSource 총 3번 실행된다. 
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void testWithValueSource(int argument) {
        assertTrue(argument > 0 && argument < 4);
    }
    
    // 주석의 value는 옵셕사항이다. 생략시 첫번째 매개변수가 사용된다.
    @ParameterizedTest
    @NullSource
    @EmptySource
    // @NullAndEmptySource를 사용해서 한번에 합칠 수도 있다.
    @ValueSource(strings = { " ", "   ", "\t", "\n" })
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }
    
    @ParameterizedTest
    @EnumSource(ChronoUnit.class)
    void testWithEnumSource(TemporalUnit unit) {
        assertNotNull(unit);
    }
   
    // enum value는 다음과 같이 사용할 수도 있다.
    @ParameterizedTest
    @EnumSource
    void testWithEnumSourceWithAutoDetection(ChronoUnit unit) {
        assertNotNull(unit);
    }
    
    // 지정된 enum 유형을 선택해서 사용할 수도 있다.
    @ParameterizedTest
    @EnumSource(names = { "DAYS", "HOURS" })
    void testWithEnumSourceInclude(ChronoUnit unit) {
        assertTrue(EnumSet.of(ChronoUnit.DAYS, ChronoUnit.HOURS).contains(unit));
    }
    
    // enum 지정 시 정규식을 사용할 수도 있다.
    @ParameterizedTest
    @EnumSource(mode = EnumSource.Mode.MATCH_ALL, names = "^.*DAYS$")
    void testWithEnumSourceRegex(ChronoUnit unit) {
        assertTrue(unit.name().endsWith("DAYS"));
    }
}
