package com.rurigokou.common.exception;

import com.rurigokou.common.response.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 错误处理器
 * @author gokoururi
 */
@Slf4j
@RestControllerAdvice
public class RuriExceptionHandler {

    @ExceptionHandler({RuriException.class})
    public ResultResponse<String> ruriException(HttpServletRequest request, RuriException exception) {
        log.warn(exception.toString() + "; " + request.getRequestURI());

        return new ResultResponse<String>(exception.getErrorCode())
                .setUri(request.getRequestURI())
                .setError(exception.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResultResponse<String> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException exception) {
        log.warn(exception.toString() + "; " + request.getRequestURI());

        Map<String, String> map = new HashMap<>(16);
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResultResponse.error(RuriErrorCodeEnum.VALID_EXCEPTION)
                .setError(map)
                .setUri(request.getRequestURI());
    }

    @ExceptionHandler({NoHandlerFoundException.class, HttpRequestMethodNotSupportedException.class, Exception.class})
    public ResultResponse<String> allException(HttpServletRequest request, Exception exception) {
        log.warn(exception.toString() + "; uri:" + request.getRequestURI());

        ResultResponse<String> resultResponse;

        if(exception instanceof NoHandlerFoundException) {
            resultResponse=new ResultResponse<>(RuriErrorCodeEnum.NOT_FOUND_EXCEPTION);
        } else if (exception instanceof HttpRequestMethodNotSupportedException) {
            resultResponse= ResultResponse.error(RuriErrorCodeEnum.REQUEST_METHOD_NOT_SUPPORT_EXCEPTION);
        } else {
            resultResponse= ResultResponse.error(RuriErrorCodeEnum.UNKNOWN_EXCEPTION);
        }

        return resultResponse
                .setUri(request.getRequestURI())
                .setError(exception.getMessage());
    }
}
