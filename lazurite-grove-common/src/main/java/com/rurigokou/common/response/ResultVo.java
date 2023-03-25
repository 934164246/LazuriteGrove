package com.rurigokou.common.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.rurigokou.common.exception.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 返回结果集
 *
 * @author gokoururi
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVo<T> {

    /**
     * 状态码
     */
    private Integer code = 200;

    /**
     * 提示信息
     */
    private String message = "操作成功";

    /**
     * 路径
     */
    private String uri;

    /**
     * 状态
     */
    private Object error;

    /**
     * 数据
     */
    private T data;

    public ResultVo() {

    }

    public ResultVo(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getDescription();
    }

    /**
     * 成功处理请求
     *
     * @param data 数据
     * @param <T>  T
     * @return resultVo
     */
    public static <T> ResultVo<T> success(T data) {
        return ResultVo.success(data, "操作成功");
    }

    /**
     * 成功处理请求
     *
     * @param data    数据
     * @param message 提示信息
     * @param <T>     T
     * @return resultVo
     */
    public static <T> ResultVo<T> success(T data, String message) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.code = 200;
        resultVo.data = data;
        resultVo.message = message != null ? message : resultVo.message;

        return resultVo;
    }

    /**
     * 失败请求处理，默认是500错误
     *
     * @param error 错误提示信息
     * @return resultVo
     */
    public static ResultVo<String> error(String error) {
        ResultVo<String> resultVo = new ResultVo<>();
        resultVo.code = 500;
        resultVo.message = error;

        return resultVo;
    }

    /**
     * 失败请求处理
     *
     * @param errorCode 枚举类型
     * @return ResultVo
     */
    public static ResultVo<String> error(ErrorCode errorCode) {
        return new ResultVo<>(errorCode);
    }
}
