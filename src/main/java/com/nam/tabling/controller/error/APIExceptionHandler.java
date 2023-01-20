package com.nam.tabling.controller.error;

import com.nam.tabling.constant.ErrorCode;
import com.nam.tabling.dto.APIErrorResponse;
import com.nam.tabling.exception.GeneralException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice(annotations = RestController.class) // Rest컨트롤러의 동작을 감시 + ResponseBody
public class APIExceptionHandler extends ResponseEntityExceptionHandler {
// ResponseEntityExceptionHandler : Spring mvc를 사용할 때 나타나는 exception을 핸들링 한다.

    @ExceptionHandler
    public ResponseEntity<Object> validation(ConstraintViolationException e, WebRequest request) {
        return getInternalResponseEntity(e, ErrorCode.VALIDATION_ERROR, HttpHeaders.EMPTY, HttpStatus.BAD_REQUEST,request);
    }

    @ExceptionHandler
    public ResponseEntity<Object> general(GeneralException e, WebRequest request) {
        ErrorCode errorCode = e.getErrorcode();
        HttpStatus status = errorCode.isClientSideError() ?
                HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;

        return getInternalResponseEntity(e, errorCode, HttpHeaders.EMPTY, status,request);
    }

    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception e, WebRequest request) {
        return getInternalResponseEntity(e, ErrorCode.INTERNAL_ERROR, HttpHeaders.EMPTY, HttpStatus.INTERNAL_SERVER_ERROR,request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorCode errorCode = status.is4xxClientError() ?
                ErrorCode.SPRING_BAD_REQUEST : ErrorCode.SPRING_INTERNAL_ERROR;

        return getInternalResponseEntity(ex, errorCode, HttpHeaders.EMPTY, status,request);
    }

    private ResponseEntity<Object> getInternalResponseEntity(Exception e, ErrorCode errorCode, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(
                e,
                APIErrorResponse.of(false, errorCode.getCode(), errorCode.getMessage(e)),
                headers,
                status,
                request
        );
    }
}
