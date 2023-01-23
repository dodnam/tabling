package com.nam.tabling.domain.controller.error;

import com.nam.tabling.domain.constant.ErrorCode;
import com.nam.tabling.domain.dto.APIErrorResponse;
import com.nam.tabling.domain.exception.GeneralException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("프로젝트 일반 오류 - 응답 데이터 정의")
    @Test
    void givenGeneralException_whenCallingValidation_thenReturnResponseEntity() {
        // given
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        GeneralException e = new GeneralException(errorCode);

        // when
        ResponseEntity<Object> response = sut.general(e, webRequest);
        response.getBody();

        // then
        assertThat(response)
                .hasFieldOrPropertyWithValue("body", APIErrorResponse.of(false, e.getErrorcode(), e))
                .hasFieldOrPropertyWithValue("headers", HttpHeaders.EMPTY)
                .hasFieldOrPropertyWithValue("statusCode", e.getErrorcode().isClientSideError() ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @DisplayName("기타 전체 오류 - 응답 데이터 정의")
    @Test
    void givenOtherException_whenCallingValidation_thenReturnResponseEntity() {
        // given
        Exception e = new Exception();

        // when
        ResponseEntity<Object> response = sut.exception(e, webRequest);
        response.getBody();

        // then
        assertThat(response)
                .hasFieldOrPropertyWithValue("body", APIErrorResponse.of(false, ErrorCode.INTERNAL_ERROR, e))
                .hasFieldOrPropertyWithValue("headers", HttpHeaders.EMPTY)
                .hasFieldOrPropertyWithValue("statusCode", HttpStatus.INTERNAL_SERVER_ERROR);

    }
}