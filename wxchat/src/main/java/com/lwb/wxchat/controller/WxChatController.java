package com.lwb.wxchat.controller;

import com.lwb.wxchat.service.WxService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-04-04 15:50
 **/
@RestController
public class WxChatController {


    @GetMapping("/wx")
    public void access(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        //校验证签名
        if(WxService.check(timestamp,nonce,signature)) {
            System.out.println("接入成功");
            PrintWriter out = response.getWriter();
            //原样返回echostr参数
            out.print(echostr);
            out.flush();
            out.close();
        }else {
            System.out.println("接入失败");
        }
    }



    @PostMapping("/wx")
    public void event(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String> map =  WxService.parseRequest(request.getInputStream());
        System.out.println(map);
    }


    //读取用户输入信息
//    public void test(){
//        ServletInputStream inputStream = request.getInputStream();
//        byte[] b = new byte[1024];
//        int len;
//        StringBuffer sb = new StringBuffer();
//        while ((len = inputStream.read(b)) != -1){
//            sb.append(new String(b,0,len));
//        }
//        System.out.println(sb);
//
//    }

}
