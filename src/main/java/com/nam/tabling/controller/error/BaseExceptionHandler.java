package com.nam.tabling.controller.error;

import com.nam.tabling.constant.ErrorCode;
import com.nam.tabling.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@ControllerAdvice // 전체 컨트롤러의 동작을 감시
public class BaseExceptionHandler {

    @ExceptionHandler
    public ModelAndView general(GeneralException e) {
        ErrorCode errorCode = e.getErrorCode();

        return new ModelAndView(
                "error",
                Map.of(
                        "statusCode", errorCode.getHttpStatus().value(),
                        "errorCode", errorCode,
                        "message", errorCode.getMessage()
                ),
                errorCode.getHttpStatus()
        );
    }

    @ExceptionHandler
    public ModelAndView exception(Exception e, HttpServletResponse response) {
        HttpStatus httpStatus = HttpStatus.valueOf(response.getStatus());
        ErrorCode errorCode = httpStatus.is4xxClientError() ? ErrorCode.BAD_REQUEST : ErrorCode.INTERNAL_ERROR;

        if (httpStatus == HttpStatus.OK) {
            httpStatus = HttpStatus.FORBIDDEN;
            errorCode = ErrorCode.BAD_REQUEST;
        }

        return new ModelAndView(
                "error",
                Map.of(
                        "statusCode", httpStatus.value(),
                        "errorCode", errorCode,
                        "message", errorCode.getMessage(e)
                ),
                httpStatus
        );
    }

}

