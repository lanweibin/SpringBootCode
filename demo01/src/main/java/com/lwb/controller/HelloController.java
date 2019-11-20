package com.lwb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: demo01
 * @description:
 * @author: LWB
 * @create: 2019-11-17 18:28
 **/
@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }


    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "测试分支";
    }




}
