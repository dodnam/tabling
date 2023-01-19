package com.nam.tabling.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ErrorCodeTest {

    @ParameterizedTest(name = "[{index}] {0} ===> {1}") // 파라미터 테스트
    @MethodSource // 입력 소스로 method를 쓰겠다
    @DisplayName("예외를 받으면, 예외 메시지가 포함된 메시지 출력")
    void givenExceptionWithMessage_whenGettingMessage_thenReturnsMessage(ErrorCode sut, String expected) {
        // given
        Exception e = new Exception("This is test message");

        // when
        String actual = sut.getMessage(e);

        // then
        assertThat(actual).isEqualTo(expected);

    }

    static Stream<Arguments> givenExceptionWithMessage_whenGettingMessage_thenReturnsMessage() {
        return Stream.of(
                arguments(ErrorCode.OK, "OK - This is test message"),
                arguments(ErrorCode.BAD_REQUEST, "BAD_REQUEST - This is test message"),
                arguments(ErrorCode.SPRING_BAD_REQUEST, "SPRING - This is test message"),
                arguments(ErrorCode.VALIDATION_ERROR, "VALIDATION - This is test message"),
                arguments(ErrorCode.INTERNAL_ERROR, "INTERNAL - This is test message"),
                arguments(ErrorCode.SPRING_INTERNAL_ERROR, "SPRING_INTERNAL - This is test message")
        );
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" ===> \"{1}\"") // 파라미터 테스트
    @MethodSource // 입력 소스로 method를 쓰겠다
    @DisplayName("에러 메시지를 받으면, 해당 에러 메시지로 출력")
    void givenMessage_whenGettingMessage_thenReturnsMessage(String input, String expected) {
        // given

        // when
        String actual = ErrorCode.INTERNAL_ERROR.getMessage(input);

        // then
        assertThat(actual).isEqualTo(expected);

    }

    static Stream<Arguments> givenMessage_whenGettingMessage_thenReturnsMessage() {
        return Stream.of(
                arguments(null, ErrorCode.INTERNAL_ERROR.getMessage()),
                arguments("", ErrorCode.INTERNAL_ERROR.getMessage()),
                arguments("   ", ErrorCode.INTERNAL_ERROR.getMessage()),
                arguments("This is test message", "This is test message")
        );
    }

}
