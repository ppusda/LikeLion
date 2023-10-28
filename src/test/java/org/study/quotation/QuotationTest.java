package org.study.quotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;
import org.study.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class QuotationTest {

    @Test
    @DisplayName("명언 앱이 시작되면 종료 명령어로 종료할 수 있다.")
    void offQuotationApp() {
        Scanner scanner = TestUtil.genScanner("""
                종료
                    """);
    }
}
