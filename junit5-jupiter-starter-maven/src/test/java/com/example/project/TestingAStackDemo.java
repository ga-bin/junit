package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

// 중첩테스트
// 중첩테스트에서는 내부 테스트가 실행되기 전에 외부 테스트의 설정 코드가 먼저 실행된다.
// 따라서 모든 테스트를 독립적으로 실행할 수 있는 기능을 제공한다
// 외부 테스트의 설정 코드가 항상 실행되기 때문에 외부테스트를 실행하지 않고 내부 테스트만 실행할 수도 있다.
public class TestingAStackDemo {

	Stack<Object> stack;
	
	@Test
	@DisplayName("is instantiated with new Stack()")
	void isInstantiatedWithNew() {
		new Stack<>();
	}
	
	@Nested
	@DisplayName("when new")
	class WhenNew {
		
		@BeforeEach
		void createNewStack() {
			stack = new Stack<>();	
		}
		
		@Test
		@DisplayName("is empty")
		void isEmpty() {
			assertTrue(stack.isEmpty());
		}
		
		@Test
		@DisplayName("throws EmptyStackException when popped")
		void throwsExceptionWhenPopped() {
			assertThrows(EmptyStackException.class, stack::pop);
		}
		
		@Test
		@DisplayName("throws EmptyStackException when peeked")
		void throwsExceptionWhenPeeked() {
			assertThrows(EmptyStackException.class, stack::peek);
		}
		
		@Nested
		@DisplayName("after pushing an element")
		class AfterPushing {
			String anElement = "an element";
		
			@BeforeEach
			void pushAnElement() {
				stack.push(anElement);
			}
		
			@Test
			@DisplayName("it is no longer empty")
			void isNotEmpty() {
				assertFalse(stack.isEmpty());
			}
			
			@Test
			@DisplayName("returns the element when popped and is empty")
			void returnElementWhenPopped() {
				assertEquals(anElement, stack.pop());
				assertTrue(stack.isEmpty());
			}
			
			@Test
			@DisplayName("returns the element when peeked out but remains not empty")
			void returnElementWhenPeeked() {
				assertEquals(anElement, stack.peek());
				assertFalse(stack.isEmpty());
			}
		}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
