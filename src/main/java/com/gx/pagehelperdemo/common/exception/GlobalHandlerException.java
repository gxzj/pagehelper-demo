package com.gx.pagehelperdemo.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * aop方式全局处理异常
 */
@ControllerAdvice
public class GlobalHandlerException {

    //处理自定义异常
    @ExceptionHandler(value = {CustomerException.class})
    public ModelAndView handleCustomerException(CustomerException e){
        Map<String, Object> map = new HashMap<>();
        map.put("ex", e);
        return new ModelAndView("/error/cus_error", map); //跳转自定义异常界面
    }

    //处理系统异常
    @ExceptionHandler(value = {RuntimeException.class})
    public ModelAndView handleSystemException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("ex", e);
        return new ModelAndView("/error/sys_error", map); //跳转系统异常界面
    }

    //处理全局异常
    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleGlobalException(Exception e){
        Map<String, Object> map = new HashMap<>();
        map.put("ex", e);
        return new ModelAndView("/error/global_error", map); //跳转全局异常界面
    }

}
