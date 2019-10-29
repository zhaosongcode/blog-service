package org.personal.blog.config.excetion;

import org.personal.blog.pojo.result.Result;
import org.personal.blog.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zs on 2019/8/1
 * 捕获全局异常
 * 只能捕获controller曾的异常
 * service曾需要抛出异常并且不进行catch处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception ex) {
        return ResultUtil.exception();
    }
}
