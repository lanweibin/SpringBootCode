package com.lwb.service;

import com.lwb.entites.BaseMessage;
import com.lwb.entites.TextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-03-22 15:43
 **/
public class WXService {

    private static final String TOKEN = "lwb";

    /**
     * 校验接入
     *
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    public static boolean check(String timestamp, String nonce, String signature) {
//        1）将token、timestamp、nonce三个参数进行字典序排序
        String[] arr = new String[]{TOKEN, timestamp, nonce};
        Arrays.sort(arr);
//    2）将三个参数字符串拼接成一个字符串进行sha1加密
        String str = arr[0] + arr[1] + arr[2];
        String mysig = sha1(str);

//    3）开发者获得加密后的字符串可与signature对比
        return mysig.equalsIgnoreCase(signature);
    }

    private static String sha1(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("sha1");
            byte[] digest = md.digest(str.getBytes());
            char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
//                System.out.println("右移4位与16进制数与15=====" +   String.valueOf((b>>4)&15));
                sb.append(chars[(b >> 4) & 15]);
                sb.append(chars[b & 15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析xml  数据包
     *
     * @param inputStream
     * @return
     */
    public static Map<String, String> parseRequest(ServletInputStream inputStream) {
        SAXReader reader = new SAXReader();

        Map<String, String> map = new HashMap<String, String>();
        try {
            Document read = reader.read(inputStream);
            Element root = read.getRootElement();

            List<Element> elements = root.elements();
            for (Element e : elements) {
                map.put(e.getName(), e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return map;
    }

    //回复的数据包
    public static String getRespose(Map<String, String> requestMap) {
        BaseMessage msg = null;
        String strType = requestMap.get("MsgType");
        switch (strType) {
            case "text":
                msg = dealTextMessage(requestMap);
                break;
            case "image":
                break;
            case "voice":
                break;
            case "video":
                break;
            case "shortvideo":
                break;
            case "location":
                break;
            case "link":
                break;
            case "event":
                break;
            default:
                break;

        }

        System.out.println(msg);
        return  null;
    }

    /**
     * 处理文本回复消息
     * @param requestMap
     * @return
     */
    private static BaseMessage dealTextMessage(Map<String, String> requestMap) {
        TextMessage tm = new TextMessage(requestMap, "你要干嘛");
        return  tm;
    }
}
