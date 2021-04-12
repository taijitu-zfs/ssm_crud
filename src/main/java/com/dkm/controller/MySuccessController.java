package com.dkm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MySuccessController {

    @RequestMapping("/hello")
    public String success(){
        System.out.println("请求成功，页面转发");
        return "success";
    }

    @RequestMapping("/hello1")
    public String success1(){
//        System.out.println("请求成功，页面转发");
        return "zsgc";
    }

    @RequestMapping("/setAttribute")
    public String setAttribute(ModelMap modelMap){
//        modelMap.addAttribute("mdsess","传一个值");
        modelMap.put("mdput","好好好");
        return "success";
    }

    @RequestMapping("/setAttributea")
    public ModelAndView setAttribute(ModelAndView modelAndView){
        modelAndView.addObject("mdsessa","传一个值");
        modelAndView.setViewName("success");
        return modelAndView;
    }

}
