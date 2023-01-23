package com.nam.tabling.domain.exception;

import com.nam.tabling.domain.constant.ErrorCode;
import lombok.Getter;

@Getter
public class GeneralException extends RuntimeException{

    private final ErrorCode errorcode;

    public GeneralException() {
        super();
        this.errorcode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(String message) {
        super(message);
        this.errorcode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(String message, Throwable cause) {
        super(message, cause);
        this.errorcode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(Throwable cause) {
        super(cause);
        this.errorcode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorcode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorcode = errorCode;
    }

    public GeneralException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorcode = errorCode;
    }

    public GeneralException(ErrorCode errorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(errorCode.getMessage(), cause, enableSuppression, writableStackTrace);
        this.errorcode = ErrorCode.INTERNAL_ERROR;
    }


}
