package com.eric.moviego.advice;

import lombok.Getter;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 15.
 **/
public enum ExceptionEnum {
    UNKNOWN_ERROR("-9999", "알 수 없는 오류가 발생했습니다."),
    ACCESS_DENIED("-9997", "해당 리소스에 접근하기 위한 권한이 없습니다."),
    INVALID_SIGNATURE_JWT("-9996", "인증 정보가 잘못되었습니다."),
    INVALID_JWT("-9995", "인증 정보가 잘못되었습니다."),
    EXPIRED_JWT("-9994", "로그인 정보가 만료되었습니다."),
    EMPTY_CLAIM_JWT("-9993", "인증 정보가 잘못되었습니다.");

    @Getter
    private String code;
    @Getter
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
