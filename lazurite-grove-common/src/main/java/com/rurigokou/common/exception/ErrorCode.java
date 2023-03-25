package com.rurigokou.common.exception;

/**
 * 错误代码
 *
 * @author gokoururi
 */
public interface ErrorCode {

    /**
     * 获取code
     *
     * @return code
     */
    Integer getCode();

    /**
     * 得到描述
     *
     * @return 描述
     */
    String getDescription();
}
