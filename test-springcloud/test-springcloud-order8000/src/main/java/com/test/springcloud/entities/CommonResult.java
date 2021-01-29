package com.test.springcloud.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @Auther: 张夫业
 * @Date: 2021/1/20
 * @Description:
 */
@Data
@JsonFormat
public class CommonResult<T> {
    private int code;
    private String msg;
    private T data;


    public CommonResult() {
    }

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
