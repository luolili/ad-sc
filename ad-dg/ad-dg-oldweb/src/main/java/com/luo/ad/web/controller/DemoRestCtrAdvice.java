package com.luo.ad.web.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.TimeoutException;

/**
 * 传统的解决方法,拦截 controller
 */
@RestControllerAdvice(assignableTypes = {DemoRestCtr.class})
public class DemoRestCtrAdvice {


    @ExceptionHandler(TimeoutException.class)
    public Object handleEx(Throwable t) {

        return t.getMessage();
    }
}
