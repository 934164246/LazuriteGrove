package com.rurigokou.common.exception;


/**
 * 错误格式代码，默认500错误
 *
 * @author gokoururi
 */
public enum RuriErrorCodeEnum implements ErrorCode {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 系统500级别的错误
     */
    UNKNOWN_EXCEPTION(10000, "未知错误"),

    /**
     * 参数校验失败
     */
    VALID_EXCEPTION(10001, "参数校验失败"),

    /**
     * 请求类型不支持
     */
    REQUEST_METHOD_NOT_SUPPORT_EXCEPTION(10002, "请求类型不支持"),

    NOT_FOUND_EXCEPTION(10003, "路径错误"),

    PERMISSION_DENIED(1004, "权限不足"),


    // Token相关
    SIGNATURE_EXCEPTION(10100, "无效签名"),
    TOKEN_ALGORITHM_ERROR_EXCEPTION(10101, "Token算法不一致"),
    TOKEN_EXPIRED_EXCEPTION(10102, "Token过期"),
    TOKEN_FAILURE_EXCEPTION(10103, "Token失效"),
    TOKEN_PAYLOAD_EXCEPTION(10104, "payload无效"),

    NO_TOKEN_EXCEPTION(10104, "未携带Token"),


    //登录时候的问题
    NOT_LOGIN_EXCEPTION(10200, "用户未登录"),
    ACCOUNT_PASSWORD_EXCEPTION(10201, "账号或密码错误");


    private final Integer code;

    private final String description;

    RuriErrorCodeEnum(String message) {
        this.code = 500;
        this.description = message;
    }

    RuriErrorCodeEnum(int code, String message) {
        this.code = code;
        this.description = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
