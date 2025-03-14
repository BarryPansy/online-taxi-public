package com.pansiyi.internalcommon.constant;

import lombok.Getter;

public enum CommonStatusEnum {

    SUCCESS(1, "success"), FAIL(0, "fail");

    @Getter
    private int code;
    @Getter
    private String msg;

    CommonStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
