package com.lwb.springbootcrud.controller;

import com.lwb.springbootcrud.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-01-10 20:35
 **/

@ControllerAdvice
public class MyExceptionHandlder {

//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception e){
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("code","user.notexist");
//        map.put("message",e.getMessage());
//        return map;
//    }



    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误状态码  4xx 5xx
        /**
         * Integer statusCode = (Integer) request
         .getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notexist");
        map.put("message", "用户出错啦");

        request.setAttribute("ext", map);
        //转发到/error
        return "forward:/error";
    }
}
