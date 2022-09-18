package com.eric.moviego.common;

/**
 * @Author Eric
 * @Description
 * @Since 22. 9. 15.
 **/
public enum CommonResponse {
    SUCCESS(0, "Success");

    int code;
    String msg;

    CommonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
