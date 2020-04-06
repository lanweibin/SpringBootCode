package com.lwb.wxchat;

import com.lwb.wxchat.entity.*;
import com.lwb.wxchat.service.WxService;
import com.thoughtworks.xstream.XStream;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-04-04 18:15
 **/
public class test {

    @Test
    public void getAccessToken(){

        long a = System.currentTimeMillis()+Integer.parseInt("7200")*1000;
        System.out.println(a);
        String accessToken = WxService.getAccessToken();
        System.out.println(accessToken);
    }

    @Test
    public void testMsg() {
        Map<String, String> map = new HashMap<>();
        map.put("ToUserName", "to");
        map.put("FromUserName", "from");
        map.put("MsgType", "type");
        TextMessage tm = new TextMessage(map, "还好");
        XStream stream = new XStream();
        // 设置需要处理XStreamAlias("xml")注释的类
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(MusicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);


        VoiceMessage vm = new VoiceMessage(map, "1212");
        String xml = stream.toXML(tm);

        String xm2 = stream.toXML(vm);
        System.out.println(xml);
        System.out.println(xm2);

    }
}
