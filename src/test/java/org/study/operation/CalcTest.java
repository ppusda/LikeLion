package org.study.operation;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalcTest {

    @Test
    @DisplayName("Calc에 run 메서드는 int를 리턴한다.")
    void CalcReturnTest() {
        int result = Calc.run("");
    }

    @Test
    @DisplayName("Calc에 run 메서드는 알맞은 사칙연산 값을 리턴 한다.")
    void CalcResultTest() {
        assertThat(Calc.run("10 + 10")).isEqualTo(20);
        assertThat(Calc.run("10 - 10")).isEqualTo(0);
        assertThat(Calc.run("10 * 10")).isEqualTo(100);
        assertThat(Calc.run("10 / 10")).isEqualTo(1);
    }

    @Test
    @DisplayName("괄호가 들어간 사칙연산을 성공한다.")
    void CalcReturnWithBracketTest() {
        assertThat(Calc.run("(10 + 10)")).isEqualTo(20);
        assertThat(Calc.run("(10 - 10)")).isEqualTo(0);
        assertThat(Calc.run("(10 * 10)")).isEqualTo(100);
        assertThat(Calc.run("(10 / 10)")).isEqualTo(1);
    }

}
