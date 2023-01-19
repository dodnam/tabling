package com.nam.tabling.controller.error;

import com.nam.tabling.constant.ErrorCode;
import com.nam.tabling.dto.APIErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class APIExceptionHandlerTest {

    private APIExceptionHandler sut;
    private WebRequest webRequest;
    private HttpServletRequest httpServletRequest;

    @BeforeEach
    void setUp() {
        sut = new APIExceptionHandler();
        webRequest = new DispatcherServletWebRequest(new MockHttpServletRequest());
    }

    @DisplayName("검증 오류 - 응답 데이터 정의")
    @Test
    void givenException_whenCallingValidation_thenReturnResponseEntity() {
        // given
        ConstraintViolationException e = new ConstraintViolationException(Set.of());

        // when
        ResponseEntity<Object> response = sut.validation(e, webRequest);
        response.getBody();

        // then
        assertThat(response)
                .hasFieldOrPropertyWithValue("body", APIErrorResponse.of(false, ErrorCode.VALIDATION_ERROR, e))
                .hasFieldOrPropertyWithValue("headers", HttpHeaders.EMPTY)
                .hasFieldOrPropertyWithValue("statusCode", HttpStatus.BAD_REQUEST);

    }
}