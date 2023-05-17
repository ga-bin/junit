package com.example.project;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

// 선언적으로 컨테이너 및 텍스트를 활성화, 비활성화 할 수 있다.
public class executionConditionTests {

	
	private static final JRE[] JAVA = null;

	// --------------------------------------운영체제 기반 조건부 실행--------------------------------------
	@Test
	@EnabledOnOs(OS.MAC)
	void onlyOnMacOs() {
		// MAC OS에서만 실행
	}
	@Test
	@EnabledOnOs({ OS.LINUX, OS.MAC })
	void onLinuxOrMac() {
	    // ...
	}

	@Test
	@DisabledOnOs(OS.WINDOWS)
	void notOnWindows() {
	    // ...
	}

	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	@Test
	@EnabledOnOs(OS.MAC)
	@interface TestOnMac {
	}
	
	// -------------------------------------아키텍처 기반 조건부 실행----------------------------------------
	@Test
	@EnabledOnOs(architectures = "aarch64")
	void onAarch64() {
	    // ...
	}

	@Test
	@DisabledOnOs(architectures = "x86_64")
	void notOnX86_64() {
	    // ...
	}

	@Test
	@EnabledOnOs(value = OS.MAC, architectures = "aarch64") void onNewMacs() {
	    // ...
	}

	@Test
	@DisabledOnOs(value = OS.MAC, architectures = "aarch64")
	void notOnNewMacs() {
	    // ...
	}
	
	// -----------------------------------자바 런타임 환경 조건---------------------------------------------
	@Test
	@EnabledOnJre(JRE.JAVA_8)
	void onlyOnJava8() {
	    // ...
	}

	@Test
	@EnabledOnJre({ JRE.JAVA_9, JRE.JAVA_10 })
	void onJava9Or10() {
	    // ...
	}

	@Test
	@EnabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
	void fromJava9to11() {
	    // ...
	}

	@Test
	@EnabledForJreRange(min = JRE.JAVA_9)
	void fromJava9toCurrentJavaFeatureNumber() {
	    // ...
	}

	@Test
	@EnabledForJreRange(max = JRE.JAVA_11)
	void fromJava8To11() {
	    // ...
	}

	@Test
	@DisabledOnJre(JRE.JAVA_9)
	void notOnJava9() {
	    // ...
	}

	@Test
	@DisabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
	void notFromJava9to11() {
	    // ...
	}

	@Test
	@DisabledForJreRange(min = JRE.JAVA_9)
	void notFromJava9toCurrentJavaFeatureNumber() {
	    // ...
	}

	@Test
	@DisabledForJreRange(max = JRE.JAVA_11)
	void notFromJava8to11() {
	    // ...
	}
	
}
