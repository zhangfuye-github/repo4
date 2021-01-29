package com.test.springcloud.entities;

import lombok.Data;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/20
 * @Description:
 */
@Data
public class CommonResult<T> {
    private int code;
    private String msg;
    private T data;

    public CommonResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
