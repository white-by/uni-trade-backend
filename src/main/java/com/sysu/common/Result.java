package com.sysu.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回包装类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    // 无数据成功返回
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("请求成功");
        return result;
    }

    // 带数据返回
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("请求成功");
        result.setData(data);
        return result;
    }

    // 无数据失败返回
    public static <T> Result<T> error() {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage("系统错误");
        return result;
    }

    // 带数据失败返回
    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
