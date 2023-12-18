package com.sixing.jianli.constant;

/**
 * @author zLcw
 * @version V1.0.0
 * @date 2023-12-15 11:31
 * @description 返回结果状态码
 */
public interface ResultCode {

    public final Integer SUCCESS = 20000;
    public final Integer ERROR = 20001;

    /**
     * token 失效
     */
    public final Integer TOKEN_ERROR = 20002;

}
