package com.dkm.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//这个类是专门处理异常的
@ControllerAdvice
public class MyExceptionController {

    @ExceptionHandler(value = {Exception.class})
    public ModelAndView handleException(Exception exception){
        System.out.println("handleException..."+exception);
        ModelAndView modelAndView = new ModelAndView("myerror");
        modelAndView.addObject("ex",exception);
        return modelAndView;
    }
}
