package com.luo.ad.advice;

import com.luo.ad.exception.AdException;
import com.luo.ad.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(AdException.class)
    public CommonResponse<String> handlerAdException(HttpServletRequest req, AdException ex) {

        CommonResponse<String> response = new CommonResponse<>(-1, "business ex");
        response.setData(ex.getMessage());
        return response;
    }
}
