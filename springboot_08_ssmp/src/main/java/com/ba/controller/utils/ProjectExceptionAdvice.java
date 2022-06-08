package com.ba.controller.utils;

//作为springmvc的异常处理器

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice //定义为异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //拦截所有异常信息
    @ExceptionHandler
    public R doException(Exception ex){
        //记录日志
        //通知运维
        //通知开发
        ex.printStackTrace(); //输出到控制台，不然异常被吃了不知道发生什么异常
        return new R("服务器故障，请稍后再试！");
    }
}
