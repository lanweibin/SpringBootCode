package com.lwb.entites;

import java.util.Map;

/**
 * @program: SpringBootCode
 * @description:
 * @author: LWB
 * @create: 2020-03-22 21:15
 **/
public class BaseMessage {

    private String toUserName;

    private String fromUserName;

    private String createTime;

    private String msgType;



    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public BaseMessage(Map<String, String> requestMap){
        this.toUserName = requestMap.get("toUserName");
        this.fromUserName = requestMap.get("fromUserName");
        this.createTime = System.currentTimeMillis() / 1000 +"";
    }
}
