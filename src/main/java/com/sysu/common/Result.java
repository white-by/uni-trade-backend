package com.sysu.common;

import com.sysu.common.config.ResultCode;
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
    private String msg;
    private T data;

    // 无数据成功返回
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("请求成功");
        return result;
    }

    // 带数据返回
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("请求成功");
        result.setData(data);
        return result;
    }

    // 无数据失败返回
    public static <T> Result<T> error() {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.ERROR);
        result.setMsg("系统错误");
        return result;
    }

    // 带信息失败返回
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ResultCode.ERROR);
        result.setMsg(msg);
        return result;
    }
}
