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
public class Result {
    private Integer code;
    private String msg;
    private Object data;

    // 无数据成功返回
    public static Result success() {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("请求成功");
        return result;
    }

    // 带数据成功返回
    public static Result success(Object data) {
        Result result = success();
        result.setData(data);
        return result;
    }

    // 无数据失败返回
    public static Result error() {
        Result result = new Result();
        result.setCode(ResultCode.ERROR);
        result.setMsg("系统错误");
        return result;
    }

    // 带信息失败返回
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ResultCode.ERROR);
        result.setMsg(msg);
        return result;
    }
}

