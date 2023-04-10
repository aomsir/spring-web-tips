package com.aomsir.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 全局异常处理
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 异常处理 - 处理自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public Response<String> exceptionHandler(CustomException ex) {
        return Response.error(ex.getMessage());
    }


    /**
     * 处理别的异常处理不了的,进行兜底,直接异常消息进行封装返回
     */
    @ExceptionHandler(Exception.class)
    public Response<String> exceptionHandler(Exception ex) {
        return Response.error(ex.getMessage());
    }

}
