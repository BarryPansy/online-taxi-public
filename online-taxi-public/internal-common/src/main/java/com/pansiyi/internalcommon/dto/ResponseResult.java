package com.pansiyi.internalcommon.dto;

import com.pansiyi.internalcommon.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponseResult <T>{

    private int code;
    private String message;
    private T data;

    public static <T> ResponseResult<T> success(){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getMsg());
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getMsg()).setData(data);
    }

    public static <T> ResponseResult<T> fail(T data) {
        return new ResponseResult().setData(data);
    }

    public static ResponseResult fail(int code, String message) {
        return new ResponseResult().setCode(code).setMessage(message);
    }

    public static ResponseResult fail(int code, String message, String data) {
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }

}
