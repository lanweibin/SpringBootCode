package com.lwb.springbootcrud.controller;

import com.lwb.springbootcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2019-11-27 21:45
 **/
@Controller
public class HelloController {


//    @RequestMapping({"/", "index.html"})
//    public String index(){
//        return "index";
//    }

//    @RequestMapping({"/", "/index.html"})
//    public String index() {
//        return "index";
//    }


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user")String uesr) {
        if(uesr.equals("aaa")){
            throw new UserNotExistException();
        }
        return "hello world";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "你好啊");
        return "success";
    }
}
