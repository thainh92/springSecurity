package com.example.authendemo;

import com.example.authendemo.util.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class AuthendemoApplicationTests {
    Calculator undertest = new Calculator();

    @Test
    void itShouldAddNumber() {
        //given
        int a = 20;
        int b = 30;
        // when
        int result = undertest.add(a, b);
        int expected = 50;
        //result
        assertThat(result).isEqualTo(expected);
    }
}
