package com.lwb.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2019-12-02 21:06
 **/
@Controller
//@RequestMapping("/user")
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("userName")String userName,
                        @RequestParam("passWord")String passWord,
                        Map<String, Object> map, HttpSession session){

        if (!StringUtils.isEmpty(userName) && "123456".equals(passWord)){

            session.setAttribute("loginUser", userName);
//            return "redirect:/main.html";
            return "redirect:/main.html";
        }else {
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }
}
