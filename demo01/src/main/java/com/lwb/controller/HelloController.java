package com.lwb.controller;

import com.lwb.service.WXService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
    @RequestMapping("/wx")
    public void wx(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String method = request.getMethod();
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
       if (WXService.check(timestamp, nonce, signature)){

           System.out.println("接入成功");
           PrintWriter writer = response.getWriter();
           writer.print(echostr);
           writer.flush();
//           writer.close();
       }else {
           System.out.println("接入失败");
       }
//        return "hello world";
        System.out.println(method);

//        ServletInputStream is = request.getInputStream();
//        byte[] b = new byte[1024];
//        int len;
//        StringBuffer sb = new StringBuffer();
//        while ((len = is.read(b))!= -1){
//            sb.append(new String(b, 0, len));
//        }
//        System.out.println(sb.toString());

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        Map<String, String> requestMap =  WXService.parseRequest(request.getInputStream());
        //准备回复的数据包
        String respXml = WXService.getRespose(requestMap);
        System.out.println(requestMap);


    }


    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "测试分支";
    }




}
