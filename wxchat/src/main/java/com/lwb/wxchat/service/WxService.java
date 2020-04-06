package com.lwb.wxchat.service;

import com.alibaba.fastjson.JSONObject;
import com.lwb.wxchat.entity.*;
import com.lwb.wxchat.util.Util;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;



/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-04-04 16:29
 **/
public class WxService {
    private static final String TOKEN = "ZV4k6CUwKiKL52rh";
    private static final String APPKEY = "1fec136dbd19f44743803f89bd55ca62";
    private static final String GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    //微信公众号
    private static final String APPID = "wx7419b1346f9a84f4";
    private static final String APPSECRET = "7fef4daaf348bb9bfb362f4f417014b9";
    //百度AI
    public static final String APP_ID = "11519092";
    public static final String API_KEY = "q3TlGWWqEBG9uGvlFIBtpvY5";
    public static final String SECRET_KEY = "A14W5VRNG8my1GXYYAyNND0RjzBwxI8A";


    //用于存储token
    private static AccessToken at;


    /**
     * 验证签名
     *
     * @param timestamp
     * @param nonce
     * @param signature
     * @return by 罗召勇 Q群193557337
     */
    public static boolean check(String timestamp, String nonce, String signature) {
        //1）将token、timestamp、nonce三个参数进行字典序排序
        String[] strs = new String[]{TOKEN, timestamp, nonce};
        Arrays.sort(strs);
        //2）将三个参数字符串拼接成一个字符串进行sha1加密
        String str = strs[0] + strs[1] + strs[2];
        String mysig = sha1(str);
        //3）开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        return mysig.equalsIgnoreCase(signature);
    }

    /**
     * 进行sha1加密
     *
     * @param str
     * @return
     */
    private static String sha1(String str) {
        try {
            //获取一个加密对象
            MessageDigest md = MessageDigest.getInstance("sha1");
            //加密
            byte[] digest = md.digest(str.getBytes());
            char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            StringBuilder sb = new StringBuilder();
            //处理加密结果
            for (byte b : digest) {
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
     * 解析xml数据包
     *
     * @param is
     * @return
     */
    public static Map<String, String> parseRequest(InputStream is) {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            //读取输入流，获取文档对象
            Document document = reader.read(is);
            //根据文档对象获取根节点
            Element root = document.getRootElement();
            //获取根节点的所有的子节点
            List<Element> elements = root.elements();
            for (Element e : elements) {
                map.put(e.getName(), e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 准备回复的数据包
     *
     * @param requestMap
     * @return
     */
    public static String getRespone(Map<String, String> requestMap) {
        BaseMessage msg = null;
        String msgType = requestMap.get("MsgType");
        switch (msgType) {
            //处理文本消息
            case "text":
                msg = dealTextMessage(requestMap);
                break;
            case "image":

                break;
            case "voice":
                msg = dealVoiceMessage(requestMap);
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
        //把消息对象处理为xml数据包
//        System.out.println(msg.toString());
        if (msg != null) {
            return beanToXml(msg);
        }
        return null;
    }


    /**
     * 处理语音信息
     * @param requestMap
     * @return
     */
    private static BaseMessage dealVoiceMessage(Map<String, String> requestMap) {
        Voice vo = new Voice();
        vo.setMediaId("ZoKHOHqm1jZQQqhlUBD3NIiO7ZkCIVKdv6TeNwOPL2K70FXMZaNFrB5E40ag4YZo");
        VoiceMessage vm = new VoiceMessage(requestMap, vo);
        return vm;
    }


    /**
     * 把消息对象处理为xml数据包
     *
     * @param msg
     * @return
     */
    private static String beanToXml(BaseMessage msg) {
        XStream stream = new XStream();
        //设置需要处理XStreamAlias("xml")注释的类
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(MusicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        String xml = stream.toXML(msg);
//        xml = "<xml>\n" +
//                "<ToUserName>od2IJt0kabYYsBy7DiXMA5CSZmQk</ToUserName>\n" +
//                "<FromUserName>gh_2c9db54f2356</FromUserName>\n" +
//                "<CreateTime>1586007069</CreateTime>\n" +
//                "<MsgType>voice</MsgType>\n" +
//                "<Voice>\n" +
//                "    <MediaId>ZoKHOHqm1jZQQqhlUBD3NIiO7ZkCIVKdv6TeNwOPL2K70FXMZaNFrB5E40ag4YZo</MediaId>\n" +
//                "</Voice>\n" +
//                "</xml>";
        return xml;
    }

    /**
     * 处理文本信息
     * @param requestMap
     * @return
     */
    private static BaseMessage dealTextMessage(Map<String, String> requestMap) {
        String msg = requestMap.get("Content");
        if(msg .equals("图文")){
            List<Article> list = new ArrayList<>();
            Article article = new Article("这是标题","描述","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2534506313,1688529724&fm=26&gp=0.jpg", "www.baidu.com");
            list.add(article);
            NewsMessage nm = new NewsMessage(requestMap, list);
            return nm;
        }
        TextMessage tm = new TextMessage(requestMap, "处理成功");
        return tm;

    }



    /**
     * 获取token
     * by 罗召勇 Q群193557337
     */
    private static void getToken() {
        String url = GET_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
        String tokenStr = Util.get(url);
        JSONObject jsonObject = JSONObject.parseObject(tokenStr);
        String token = jsonObject.getString("access_token");
        String expireIn = jsonObject.getString("expires_in");
        //创建token对象,并存起来。  7200
        at = new AccessToken(token, expireIn);
    }

    /**
     * 向处暴露的获取token的方法
     * @return
     * by 罗召勇 Q群193557337
     */
    public static String getAccessToken() {
        if(at==null||at.isExpired()) {
            getToken();
        }
        return at.getAccessToken();
    }
}
