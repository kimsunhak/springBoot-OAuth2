package com.ksh.security.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    DUPLICATED_EMAIL(400, "AU_002", "이미 존재하는 이메일 입니다."),
    UNAUTHORIZED_REDIRECT_URI(400, "AU_003", "인증되지 않은 REDIRECT_URI입니다.");


    private final String code;
    private final String message;
    private final int status;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

}
