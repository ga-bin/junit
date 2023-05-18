package com.example.project.order;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// @TestMethodOrder을 통해서 MethodOrderer구현을 지정할 수 있다.
// 고유한 사용자 지정을 구현하거나 기본적으로 지원되는 MethodOrderer 구현 중 하나를 사용할 수 있다
// 기본적으로 지원되는 MethodOrderer 구현은 다음과 같다
// MethodOrderer.DisplayName: 표시 이름을 기준으로 테스트 메서드를 영숫자순으로 정렬합니다( 표시 이름 생성 우선 순위 규칙 참조 ) .
// MethodOrderer.MethodName: 이름과 공식 매개변수 목록을 기준으로 영숫자순으로 테스트 메서드를 정렬합니다.
// MethodOrderer.OrderAnnotation: 주석을 통해 지정된 값을 기준으로 숫자로 테스트 방법을 정렬합니다.@Order
// MethodOrderer.Random: 테스트 방법을 의사 무작위로 주문하고 사용자 지정 시드 구성 지원
// MethodOrderer.Alphanumeric: 이름과 공식 매개변수 목록을 기준으로 영숫자순으로 테스트 메서드를 정렬합니다 . 더 이상 사용되지 않으며 MethodOrderer.MethodName6.0에서 제거됩니다.

// 전체 테스트 스위트에 대해 전역적으로 테스트 클래스 실행 순서를 구성하려면
// junit.jupiter.testclass.order.default 구성 매개변수를ClassOrderer 사용하여 사용하려는 정규화된 클래스 이름을 지정하십시오 . 제공된 클래스는 ClassOrderer인터페이스를 구현해야 합니다.
// 고유한 사용자 지정을 구현하거나 ClassOrderer다음 기본 제공 ClassOrderer구현 중 하나를 사용할 수 있습니다.
// ClassOrderer.ClassName: 정규화된 클래스 이름을 기준으로 영숫자순으로 테스트 클래스를 정렬합니다.
// ClassOrderer.DisplayName: 표시 이름을 기준으로 테스트 클래스를 영숫자순으로 정렬합니다( 표시 이름 생성 우선 순위 규칙 참조 ).
// ClassOrderer.OrderAnnotation: 주석을 통해 지정된 값을 기준으로 테스트 클래스를 숫자로 정렬합니다.@Order
// ClassOrderer.Random: 테스트 클래스를 의사 무작위로 주문 하고 사용자 정의 시드 구성을 지원합니다.

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTestsDemo {
    @Test
    @Order(1)
    void nullValues() {
        // perform assertions against null values
    }

    @Test
    @Order(2)
    void emptyValues() {
        // perform assertions against empty values
    }

    @Test
    @Order(3)
    void validValues() {
        // perform assertions against valid values
    }
}
