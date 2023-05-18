package com.example.project.lifecycle;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

@Tag("timed")
// 이 인터페이스를 구현하는 클래스에서 확장기능을 사용할 수 있다
// 확장기능은 인터페이스에서 직접 제공되는 것은 아니며 junit에서만 제공되는 기능이다.
@ExtendWith(TimingExtension.class)
public interface TimeExecutionLogger {

}
