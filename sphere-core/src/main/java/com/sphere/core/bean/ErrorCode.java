package com.sphere.core.bean;


import lombok.Getter;
import lombok.Setter;

/**
 * @author fly
 * @date 2019/5/6 17:26
 * description: 响应码和msg
 */
public enum ErrorCode {
    /**
     * 公用模块(00) 100001->版本1，00表示公用模块，001错误码编号
     */




    /**
     * 通用模块
     */
    // 未授权
    UNAUTHORIZED(401),

    // 失败
    FAIL(-1),

    // 成功
    SUCCESS(0);


    @Setter
    @Getter
    private int code;

    ErrorCode(int code) {
        this.code = code;
    }
}
