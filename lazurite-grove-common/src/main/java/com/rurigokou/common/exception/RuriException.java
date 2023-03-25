package com.rurigokou.common.exception;

/**
 * 自定义错误集合
 *
 * @author gokoururi
 */
public class RuriException extends RuntimeException {

    protected final ErrorCode errorCode;

    /**
     * 默认错误类型为：未知错误
     */
    public RuriException() {
        super(RuriErrorCodeEnum.UNKNOWN_EXCEPTION.getDescription());
        this.errorCode = RuriErrorCodeEnum.UNKNOWN_EXCEPTION;
    }

    public RuriException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
